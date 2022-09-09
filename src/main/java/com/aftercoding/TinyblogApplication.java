package com.aftercoding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.aftercoding.mapper")
public class TinyblogApplication {

    public static void main(String[] args) {

        SpringApplication.run(TinyblogApplication.class, args);
    }

}
