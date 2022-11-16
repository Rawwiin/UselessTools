package com.example.uselesstools;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.uselesstools.mapper")
public class UselessToolsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UselessToolsApplication.class, args);
    }

}
