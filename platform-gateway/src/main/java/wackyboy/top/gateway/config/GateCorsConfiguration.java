package wackyboy.top.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class GateCorsConfiguration {

    @Bean
    public CorsFilter corsFilter () {

        // 初始化cors配置对象
        CorsConfiguration configuration = new CorsConfiguration();
        // 允许跨域的域名， 如果要携带cookie就不可以写*。 *：代表所有域名都可以跨域访问
//        configuration.addAllowedOrigin("http://localhost:8080");
        configuration.addAllowedOrigin("*");
        // 设置允许携带cookie
        configuration.setAllowCredentials(true);
        // 代表所有的请求方法：GET、POST、PUT、DELETE。。。
        configuration.addAllowedMethod("*");
        // 允许携带任何头信息
        configuration.addAllowedHeader("*");

        // 初始化cors配置源对象
        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**", configuration);
        // 返回corsFilter实例，参数：cors配置源对象
        return new CorsFilter(configurationSource);
    }

}