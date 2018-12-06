package cn.vpclub.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 泥水佬
 * @date 2017/12/14
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableZuulProxy
@ComponentScan(basePackages = {"cn.vpclub.demo"})
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}
