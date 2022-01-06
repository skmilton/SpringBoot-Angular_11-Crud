package com.example.milton.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.milton.util.UuidUtil;

@Configuration
public class AppConfig {

    @Bean
    public UuidUtil uuidUtil(){
        return new UuidUtil();
    }
}
