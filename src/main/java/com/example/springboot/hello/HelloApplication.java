package com.example.springboot.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ServletComponentScan
@SpringBootApplication
public class HelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }

    @Configuration
    @EnableWebMvc
    public class WebMvcConfg implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            WebMvcConfigurer.super.addCorsMappings(registry);
            registry.addMapping("/**")//需要跨域访问的Map路径
                    .allowedOrigins("http://localhost:4200")//允许跨域访问的ip及端口
                    .allowedHeaders("*")//允许跨域访问的Headers内容
                    .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")//允许跨域访问的方法，OPTIONS必须设置Shiro中用到
                    .allowCredentials(true);
        }
    }
}


