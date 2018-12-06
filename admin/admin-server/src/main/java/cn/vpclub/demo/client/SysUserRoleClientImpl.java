package cn.vpclub.demo.client;

import cn.vpclub.demo.feignClient.SysUserRoleClient;
import cn.vpclub.demo.model.request.SysRoleParam;
import cn.vpclub.demo.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by chentao on 2018/6/4.
 */
public class SysUserRoleClientImpl implements SysUserRoleClient {
    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Override
    public void saveOrUpdate(@RequestParam("userId") Long userId, List<Long> roleIdList) {
        sysUserRoleService.saveOrUpdate(userId,roleIdList);
    }

    @Override
    public List<Long> queryRoleIdList(@RequestParam("userId") Long userId) {
        return sysUserRoleService.queryRoleIdList(userId);
    }

    @Override
    public int deleteBatch(@RequestBody SysRoleParam params) {
        List<Long> roleIds  = params.getRoleIds();
        Long[] ids = (Long[]) roleIds.toArray();
        return sysUserRoleService.deleteBatch(ids);
    }
}
