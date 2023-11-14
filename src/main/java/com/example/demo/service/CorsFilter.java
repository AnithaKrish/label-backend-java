package com.example.demo.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc

public class CorsFilter implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
       registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET, POST, PATCH, PUT, DELETE, OPTIONS")
                .allowedHeaders("Accept, Content-Type, Content-Length, Accept-Encoding, X-CSRF-Token, Authorization")
                .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Headers", "Access-Control-Allow-Methods")
                .allowCredentials(false)
                .maxAge(3600);
        registry.addMapping("/**").allowedMethods("*");
    }
}
