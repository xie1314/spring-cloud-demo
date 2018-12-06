package cn.vpclub.demo.feignClient;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

/**
 * Created by chentao on 2018/5/31.
 */
@RequestMapping(value = "/shiroClient")
public interface ShiroClient {
    /**
     * 获取用户权限列表
     */
    @RequestMapping(value = "getUserPermissions")
    Set<String> getUserPermissions(@RequestParam("userId") long userId);
}
