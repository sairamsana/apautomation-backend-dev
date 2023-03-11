package com.bayd.apautomation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableWebMvc
public class ApautomationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApautomationApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedHeaders("Origin", "X-Requested-With", "Content-Type", "Accept", "X-Auth-Token", "X-Csrf-Token", "Authorization","Access-Control-Allow-Origin").allowedMethods("GET", "POST","PUT", "DELETE","OPTIONS");
            }
        };
    }


}
