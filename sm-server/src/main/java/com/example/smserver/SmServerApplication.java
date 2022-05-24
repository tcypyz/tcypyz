package com.example.smserver;

import com.example.smserver.config.LogInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author maoshen5478
 */
@SpringBootApplication
@Slf4j
public class SmServerApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(SmServerApplication.class, args);
            log.info("Swagger ui文档地址： http://localhost:{}/swagger-ui/index.html","8080");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Bean
    public ServletRegistrationBean<DispatcherServlet> dispatcherRegistration() {
        return new ServletRegistrationBean<>(dispatcherServlet());
    }

    @Bean(name = DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME)
    public DispatcherServlet dispatcherServlet() {
        return new LogInterceptor();
    }

}
