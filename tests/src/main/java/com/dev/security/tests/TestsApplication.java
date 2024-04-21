package com.dev.security.tests;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.dev.security.tests.dao")
@SpringBootApplication
public class TestsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestsApplication.class, args);
    }
}
