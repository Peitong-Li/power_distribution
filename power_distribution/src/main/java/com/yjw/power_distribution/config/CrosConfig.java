package com.yjw.power_distribution.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CrosConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //本应用的所有方法都会去处理跨域请求
        registry.addMapping("/**")
                //允许远端访问的域名
                .allowedOrigins("*")
                //允许请求的方法("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .allowedMethods("*")
                //允许请求头
                .allowedHeaders("*");
    }
}
