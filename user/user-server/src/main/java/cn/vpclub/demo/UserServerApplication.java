package cn.vpclub.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author likq
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan("cn.vpclub.demo")
public class UserServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServerApplication.class, args);
    }
}
