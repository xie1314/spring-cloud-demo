package cn.vpclub.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


/**
 * @author likq
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableWebMvc
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan(basePackages = {"cn.vpclub.demo"})
@MapperScan("cn.vpclub.demo.dao")
public class AdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminServerApplication.class, args);
    }
}
