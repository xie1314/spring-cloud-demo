package cn.vpclub.demo.client;

import cn.vpclub.demo.domain.entity.SysRoleEntity;
import cn.vpclub.demo.feignClient.SysRoleClient;
import cn.vpclub.demo.model.request.SysRoleParam;
import cn.vpclub.demo.service.SysRoleService;
import cn.vpclub.demo.utils.MapUtils;
import cn.vpclub.moses.core.model.response.PageResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  系统角色 服务治理实现类
 * </p>
 * @author yk
 * @since  2018-06-01
 */
@Slf4j
@RestController
public class SysRoleClientImpl implements SysRoleClient {

    @Resource
    private SysRoleService sysRoleService;

    @Override
    public PageResponse queryPage(@RequestBody SysRoleParam params) { return sysRoleService.queryPage(params); }

    @Override
    public void save(@RequestBody SysRoleEntity role) {
        sysRoleService.save(role);
    }

    @Override
    public void update(@RequestBody SysRoleEntity role) {
        sysRoleService.update(role);
    }

    @Override
    public void deleteBatch(@RequestBody SysRoleParam params) {
        List<Long> roleIds  = params.getRoleIds();
        Long[] array = new Long[roleIds.size()];
        Long[] ids = roleIds.toArray(array);
        sysRoleService.deleteBatch(ids);
    }

    @Override
    public List<Long> queryRoleIdList(@RequestBody Long createdBy) { return sysRoleService.queryRoleIdList(createdBy); }

    @Override
    public List<SysRoleEntity> selectByParam(@RequestBody SysRoleParam sysRoleParam) {
        Map<String, Object> paramMap = new HashedMap();
        try {
            paramMap = MapUtils.objectToMap(sysRoleParam);
        } catch (Exception e) {
            log.error("SysRoleClientImpl.selectByParam(),对象转换成map出错:{}",e);
        }
        return sysRoleService.selectByMap(paramMap);
    }

    @Override
    public SysRoleEntity selectById(@RequestBody Long roleId) { return sysRoleService.selectById(roleId); }
}
