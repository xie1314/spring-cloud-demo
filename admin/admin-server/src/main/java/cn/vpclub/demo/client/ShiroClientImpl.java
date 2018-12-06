package cn.vpclub.demo.client;

import cn.vpclub.demo.feignClient.ShiroClient;
import cn.vpclub.demo.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Created by chentao on 2018/6/4.
 */
@RestController
public class ShiroClientImpl implements ShiroClient {
    @Autowired
    private ShiroService shiroService;

    @Override
    public Set<String> getUserPermissions( long userId) {
        return shiroService.getUserPermissions(userId);
    }
}
