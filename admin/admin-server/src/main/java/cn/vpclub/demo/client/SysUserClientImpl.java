package cn.vpclub.demo.client;

import cn.vpclub.demo.domain.entity.SysUserEntity;
import cn.vpclub.demo.feignClient.SysUserClient;
import cn.vpclub.demo.model.request.SysLogParam;
import cn.vpclub.demo.model.request.SysUserParam;
import cn.vpclub.demo.model.response.PageUtils;
import cn.vpclub.demo.service.SysUserService;
import cn.vpclub.moses.core.model.response.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by chentao on 2018/5/31.
 */
@RestController
public class SysUserClientImpl implements SysUserClient {
    @Autowired
    private SysUserService sysUserService;
    @Override
    public SysUserEntity queryByPhone(@RequestBody SysUserEntity mobileuser) {
        return sysUserService.queryByPhone(mobileuser);
    }

    @Override
    public PageResponse queryPage(@RequestBody SysUserParam params) {
        return sysUserService.queryPage(params);
    }

    @Override
    public List<String> queryAllPerms(@RequestParam Long userId) {
        return sysUserService.queryAllPerms(userId);
    }

    @Override
    public List<Long> queryAllMenuId(@RequestParam Long userId) {
        return sysUserService.queryAllMenuId(userId);
    }

    @Override

    public SysUserEntity queryByUserName(@RequestParam String userName) {
        return sysUserService.queryByUserName(userName);
    }

    @Override
    public void save(@RequestBody SysUserEntity user) {
        sysUserService.save(user);
    }

    @Override
    public void update(@RequestBody SysUserEntity user) {
        sysUserService.update(user);
    }

    @Override
    public void deleteBatch(@RequestParam Long[] userIds) {
        sysUserService.deleteBatch(userIds);
    }

    @Override
    public boolean updatePassword(@RequestParam Long userId, String password,  String newPassword) {
        return sysUserService.updatePassword(userId,password,newPassword);
    }

    @Override
    public void deleteByUserId(@RequestBody SysUserParam params) {
        sysUserService.deleteByUserId(params.getIdList());
    }

    @Override
    public void register(@RequestBody SysUserEntity registerUser) {
        sysUserService.register(registerUser);
    }

    @Override
    public List<SysUserEntity> queryByParentId(@RequestParam String parentId) {
        return sysUserService.queryByParentId(parentId);
    }

    @Override
    public SysUserEntity selectById(@RequestParam("userId") Long userId) {
        return sysUserService.selectById(userId);
    }
}
