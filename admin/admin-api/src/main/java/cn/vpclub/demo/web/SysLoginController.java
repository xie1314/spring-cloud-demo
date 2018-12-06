package cn.vpclub.demo.web;

import cn.vpclub.demo.common.utils.RedisUtils;
import cn.vpclub.demo.domain.entity.SysUserEntity;
import cn.vpclub.demo.model.request.SysLoginForm;


import cn.vpclub.demo.model.response.LoginResponse;
import cn.vpclub.moses.core.enums.ReturnCodeEnum;
import cn.vpclub.moses.core.model.response.BackResponseUtil;
import cn.vpclub.moses.core.model.response.BaseResponse;
import cn.vpclub.moses.core.model.response.PageResponse;
import cn.vpclub.demo.service.ShiroService;
import cn.vpclub.demo.service.SysUserService;
import cn.vpclub.demo.service.SysUserTokenService;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * 登录相关
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月10日 下午1:15:31
 */
@RestController
@RequestMapping("/sys")
public class SysLoginController extends AbstractController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysUserTokenService sysUserTokenService;
    /*@Autowired
    private SysCaptchaService sysCaptchaService;*/
    @Autowired
    private ShiroService shiroService;

    @Autowired
    private RedisUtils redisUtils;


   /* *//**
     * 验证码
     *//*
    @PostMapping("captcha.jpg")
    public void captcha(HttpServletResponse response, String uuid) {
        try {
            response.setHeader("Cache-Control", "no-store, no-cache");
            response.setContentType("image/jpeg");

            //获取图片验证码
            BufferedImage image = sysCaptchaService.getCaptcha(uuid);

            ServletOutputStream out = response.getOutputStream();
            ImageIO.write(image, "jpg", out);
            IOUtils.closeQuietly(out);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    public BaseResponse login(@RequestBody SysLoginForm form) {
        BaseResponse baseResponse = null;
        try {
          /*  //验证图片验证码
            boolean captcha = sysCaptchaService.validate(form.getUuid(), form.getCaptcha());
            if (!captcha) {
                return BaseResponse.error("验证码不正确");
            }*/
            SysUserEntity user = null;
            Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
            if (pattern.matcher(form.getUsername()).matches() && form.getUsername().length() == 11) {
                SysUserEntity mobileuser = new SysUserEntity();
                mobileuser.setMobile(form.getUsername());
               /* EntityWrapper<SysUserEntity> condition = new EntityWrapper<>(mobileuser);
                user = sysUserService.selectOne(condition);*/

                user = sysUserService.queryByPhone(mobileuser);

                //手机号不存在，密码错误
                if (null == user || !user.getPassword().equals(new Sha256Hash(form.getPassword(), user.getSalt()).toHex())) {
                    baseResponse = BackResponseUtil.getBaseResponse(ReturnCodeEnum.CODE_1003.getCode());
                    baseResponse.setMessage("手机号或密码不正确");
                    return baseResponse;
                }
            } else {
                //用户信息
                user = sysUserService.queryByUserName(form.getUsername());

                //账号不存在、密码错误
                if (user == null || !user.getPassword().equals(new Sha256Hash(form.getPassword(), user.getSalt()).toHex())) {
                    baseResponse = BackResponseUtil.getBaseResponse(ReturnCodeEnum.CODE_1003.getCode());
                    baseResponse.setMessage("账号或密码不正确");
                    return baseResponse;
                }
            }

            //账号锁定
            if (user.getStatus() == 0) {
                baseResponse = BackResponseUtil.getBaseResponse(ReturnCodeEnum.CODE_1005.getCode());
                baseResponse.setMessage("账号已被锁定,请联系管理员");
                return baseResponse;
            }
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setUser(user);
            //生成token，并保存到数据库
            BaseResponse tokenResponse = sysUserTokenService.createToken(user.getUserId());
            redisUtils.set((String) tokenResponse.getDataInfo(), user);
            loginResponse.setToken((String) tokenResponse.getDataInfo());
            Set<String> permissions = shiroService.getUserPermissions(user.getUserId());
            loginResponse.setPermissions(permissions);
            baseResponse = BackResponseUtil.getBaseResponse(ReturnCodeEnum.CODE_1000.getCode());
            baseResponse.setDataInfo(loginResponse);
            return baseResponse;
        } catch (Exception e) {
            e.printStackTrace();
            baseResponse = BackResponseUtil.getBaseResponse(ReturnCodeEnum.CODE_1005.getCode());
            return baseResponse;
        }
    }


    /**
     * 退出
     */
    @PostMapping("/logout")
    public BaseResponse logout(@RequestParam long userId) {
        BaseResponse baseResponse = BackResponseUtil.getBaseResponse(ReturnCodeEnum.CODE_1000.getCode());
        sysUserTokenService.logout(userId);
        return baseResponse;
    }

}
