package com.codechallenge.openpay.restapisopenpay.config;

import com.codechallenge.openpay.restapisopenpay.web.middleware.LogEndpointInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    private final LogEndpointInterceptor logEndpointInterceptor;

    public WebConfig(LogEndpointInterceptor logEndpointInterceptor) {
        this.logEndpointInterceptor = logEndpointInterceptor;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logEndpointInterceptor);
    }
}