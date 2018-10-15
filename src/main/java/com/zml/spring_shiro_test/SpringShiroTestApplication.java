package com.zml.spring_shiro_test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.zml.spring_shiro_test.mapper")
public class SpringShiroTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringShiroTestApplication.class, args);
    }
}
