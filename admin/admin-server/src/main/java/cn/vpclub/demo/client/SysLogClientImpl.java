package cn.vpclub.demo.client;

import cn.vpclub.demo.feignClient.SysLogClient;
import cn.vpclub.demo.model.request.SysLogParam;
import cn.vpclub.demo.service.SysLogService;
import cn.vpclub.moses.core.model.response.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by chentao on 2018/5/31.
 */
@RestController
public class SysLogClientImpl implements SysLogClient {

    @Autowired
    private SysLogService sysLogService;

    @Override
    public PageResponse queryPage(SysLogParam params) {
        return sysLogService.queryPageResponse(params);
    }
}
