package cn.vpclub.demo.service;

import cn.vpclub.demo.feignClient.SysRoleClient;
import cn.vpclub.demo.feignClient.SysRoleMenuClient;
import org.springframework.cloud.netflix.feign.FeignClient;



/**
 * 角色与菜单对应关系
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:42:30
 */
@FeignClient("${feign-client.admin-server}")
public interface SysRoleMenuService extends SysRoleMenuClient{
	

	
}
