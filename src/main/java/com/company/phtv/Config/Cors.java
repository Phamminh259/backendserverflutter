package com.company.phtv.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Cors implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // <-- Cho phép tất cả domain
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*"); // <-- Cho phép tất cả header
    }
}
