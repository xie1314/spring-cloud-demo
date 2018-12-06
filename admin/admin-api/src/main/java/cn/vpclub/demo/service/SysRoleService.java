package cn.vpclub.demo.service;

import cn.vpclub.demo.feignClient.SysRoleClient;
import org.springframework.cloud.netflix.feign.FeignClient;



/**
 * 系统角色 服务类
 * 
 * @author yk
 *@since  2018-06-01
 */
@FeignClient("${feign-client.admin-server}")
public interface SysRoleService extends SysRoleClient {
}
