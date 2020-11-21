package wackyboy.top.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: WackyBoy
 * @Date: 2020/10/27 14:52
 */

@SpringBootApplication
@EnableDiscoveryClient                          // 被注册为可发现
@MapperScan(value = {"wackyboy.top.item.mapper"})      // 作用：指定要变成实现类的接口所在的包，然后包下面的所有接口在编译后都会生成响应的实现类

// 开启Feign组件
@EnableFeignClients
public class ItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ItemApplication.class);
    }
}
