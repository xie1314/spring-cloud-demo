package cn.vpclub.demo.client;

import cn.vpclub.demo.domain.entity.SysUserEntity;
import cn.vpclub.demo.feignClient.SysRefindPasswordClient;
import cn.vpclub.demo.model.request.SysRegisterForm;
import cn.vpclub.demo.service.SysUserService;
import cn.vpclub.moses.core.enums.ReturnCodeEnum;
import cn.vpclub.moses.core.model.response.BaseResponse;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.generics.tree.ReturnType;

import java.util.Map;

@Slf4j
@RestController
public class SysRefindPasswordClientImpl implements SysRefindPasswordClient{

    @Autowired
    private SysUserService sysUserService;


    @Override
    public BaseResponse refindStep3(@RequestBody SysRegisterForm form) {
        BaseResponse baseResponse = new BaseResponse();
        try {

            //判断当前找回密码的状态
           /* if (!redis.get(form.getMobile() + "RefindStatus").equals("validateCaptcha")) {
                return BaseResponse.error("你越界了哦！");
            }*/
            String salt = RandomStringUtils.randomAlphanumeric(20);
            SysUserEntity sysUserEntity = new SysUserEntity();
            sysUserEntity.setMobile(form.getMobile());
            EntityWrapper<SysUserEntity> condition = new EntityWrapper<>(sysUserEntity);

            //查询出该用户信息
            sysUserEntity = sysUserService.selectOne(condition);

            //修改密码和盐
            sysUserEntity.setPassword(new Sha256Hash(form.getPassword(), salt).toHex());
            sysUserEntity.setSalt(salt);
            sysUserService.updateById(sysUserEntity);

            baseResponse.setReturnCode(ReturnCodeEnum.CODE_1000.getCode());
            baseResponse.setMessage(ReturnCodeEnum.CODE_1000.getValue());
        } catch (Exception e) {
            log.error(e.getMessage());
            baseResponse.setReturnCode(ReturnCodeEnum.CODE_1005.getCode());
            baseResponse.setMessage(ReturnCodeEnum.CODE_1005.getValue());
        }
        return baseResponse;
    }
}
