package cn.vpclub.demo.service;

import cn.vpclub.demo.feignClient.SysMenuClient;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>
 * 系统菜单 服务类
 * </p>
 * @author  yk
 * @since  2018-06-01

 */
@FeignClient("${feign-client.admin-server}")
public interface SysMenuService extends SysMenuClient {
}
