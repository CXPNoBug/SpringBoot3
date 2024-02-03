package com.cxp.trans;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.cxp.trans.mapper")
@SpringBootApplication
public class TransApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransApplication.class, args);
    }

}
