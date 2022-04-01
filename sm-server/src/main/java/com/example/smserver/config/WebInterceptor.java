package com.example.smserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/26
 */
@Configuration
public class WebInterceptor implements WebMvcConfigurer {

    private final String[] origin = {
            "http://127.0.0.1:3250",
            "http://localhost:3250",
    };

    /**
     * 跨域申请
     *
     * @param registry 注册表
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOrigins(origin)
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .maxAge(36000L)
                .allowedHeaders("*");
    }
}
