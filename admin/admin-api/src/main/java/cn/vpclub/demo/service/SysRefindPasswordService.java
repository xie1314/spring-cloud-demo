package cn.vpclub.demo.service;

import cn.vpclub.demo.feignClient.SysRefindPasswordClient;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("${feign-client.admin-server}")
public interface SysRefindPasswordService extends SysRefindPasswordClient {
}
