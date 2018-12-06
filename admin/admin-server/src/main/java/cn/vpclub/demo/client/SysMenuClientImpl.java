package cn.vpclub.demo.client;

import cn.vpclub.demo.domain.entity.SysMenuEntity;
import cn.vpclub.demo.feignClient.SysMenuClient;
import cn.vpclub.demo.service.SysMenuService;
import cn.vpclub.moses.core.model.response.BaseResponse;
import cn.vpclub.moses.core.model.response.ResponseConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  系统菜单 服务治理实现类
 * </p>
 * @author yk
 * @since  2018-06-01
 */
@RestController
public class SysMenuClientImpl implements SysMenuClient {

    @Autowired
    private SysMenuService sysMenuService;

    @Override
    public List<SysMenuEntity> queryListParentId(@RequestBody Long parentId) {
        return sysMenuService.queryListParentId(parentId);
    }

    @Override
    public List<SysMenuEntity> queryNotButtonList() {
        return sysMenuService.queryNotButtonList();
    }

    @Override
    public List<SysMenuEntity> getUserMenuList(Long userId) {
        return sysMenuService.getUserMenuList(userId);
    }

    @Override
    public void delete(@RequestBody Long menuId) {
        sysMenuService.delete(menuId);
    }

    @Override
    public List<SysMenuEntity> selectList(@RequestBody Object o) {
        return sysMenuService.selectList(null);
    }

    @Override
    public SysMenuEntity selectById(@RequestBody Long parentId) {
        return sysMenuService.selectById(parentId);
    }

    @Override
    public BaseResponse insert(@RequestBody SysMenuEntity menu) {
        BaseResponse baseResponse = new BaseResponse();
        boolean back = sysMenuService.insert(menu);
        baseResponse= ResponseConvert.convert(back);
        return baseResponse;
    }

    @Override
    public BaseResponse updateById(@RequestBody SysMenuEntity menu) {
        BaseResponse baseResponse = new BaseResponse();
        boolean back = sysMenuService.updateById(menu);
        baseResponse= ResponseConvert.convert(back);
        return baseResponse;
    }
}
