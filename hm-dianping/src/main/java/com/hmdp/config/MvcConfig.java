package com.hmdp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 万佳军
 */
@Configuration
public class MvcConfig {


    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
    return  new WebMvcConfigurer() {
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            WebMvcConfigurer.super.addInterceptors(registry);
        }
    };
    }

}
