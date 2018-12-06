package cn.vpclub.demo.client;

import cn.vpclub.demo.feignClient.SysUserTokenClient;

import cn.vpclub.demo.service.SysUserTokenService;
import cn.vpclub.moses.core.model.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chentao on 2018/6/4.
 */
@RestController
public class SysUserTokenClientImpl implements SysUserTokenClient {
    @Autowired
    private SysUserTokenService sysUserTokenService;
    @Override
    public BaseResponse createToken(long userId) {
        return sysUserTokenService.createToken(userId);
    }

    @Override
    public BaseResponse logout(long userId) {
        return sysUserTokenService.logout(userId);
    }
}
