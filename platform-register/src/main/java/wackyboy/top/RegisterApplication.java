package wackyboy.top;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: WackyBoy
 * @Date: 2020/10/28 17:00
 */

@SpringBootApplication
@EnableEurekaServer
public class RegisterApplication {

    public static void main(String[] args) {

        SpringApplication.run(RegisterApplication.class);

    }

}
