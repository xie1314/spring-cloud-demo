package cn.vpclub.demo.client;

import cn.vpclub.demo.domain.entity.SysConfigEntity;
import cn.vpclub.demo.feignClient.SysConfigClient;
import cn.vpclub.demo.model.request.SysConfigParam;
import cn.vpclub.demo.model.response.PageUtils;
import cn.vpclub.demo.service.SysConfigService;
import cn.vpclub.moses.core.model.response.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chentao on 2018/5/31.
 */
@RestController
public class SysConfigClientImpl implements SysConfigClient {

    @Autowired
    SysConfigService sysConfigService;

    @Override
    public PageResponse queryPage(@RequestBody SysConfigParam params) {
        return sysConfigService.queryPage(params);
    }

    @Override
    public SysConfigEntity selectById(Long id) {
        return sysConfigService.selectById(id);
    }

    @Override
    public void save(@RequestBody SysConfigEntity config) {
        sysConfigService.save(config);
    }

    @Override
    public void update(@RequestBody SysConfigEntity config) {
        sysConfigService.update(config);
    }

    @Override
    public void deleteBatch(@RequestBody SysConfigParam params) {
        sysConfigService.deleteBatch(params);
    }

    @Override
    public String getValue(@RequestParam("key") String key) {
        return sysConfigService.getValue(key);
    }
}
