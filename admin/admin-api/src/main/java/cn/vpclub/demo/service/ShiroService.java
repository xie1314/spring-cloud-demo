package cn.vpclub.demo.service;

import cn.vpclub.demo.feignClient.ShiroClient;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by chentao on 2018/5/31.
 */
@FeignClient("${feign-client.admin-server}")
public interface ShiroService extends ShiroClient {
}
