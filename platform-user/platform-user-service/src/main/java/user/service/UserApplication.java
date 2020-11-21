package user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: WackyBoy
 * @Date: 2020/10/29 13:07
 */
@SpringBootApplication
// 服务的注册与发现
@EnableDiscoveryClient
// Hystrix熔断器
//@EnableCircuitBreaker
// 上面三个可以使用@SpringCloudApplication注解代替
@MapperScan("user.service.mapper")
public class UserApplication {

    public static void main(String[] args) {

        SpringApplication.run(UserApplication.class);

    }

}
