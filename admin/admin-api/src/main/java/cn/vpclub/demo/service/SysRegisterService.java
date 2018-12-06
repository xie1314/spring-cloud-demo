package cn.vpclub.demo.service;

import cn.vpclub.demo.feignClient.SysRegisterClient;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("${feign-client.admin-server}")
public interface SysRegisterService extends SysRegisterClient {
}
