package com.example.projserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.projserver.dao")
public class ProjServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjServerApplication.class, args);
    }

}
