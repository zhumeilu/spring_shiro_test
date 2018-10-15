package com.zml.spring_shiro_test.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){

        return null;
    }

}
