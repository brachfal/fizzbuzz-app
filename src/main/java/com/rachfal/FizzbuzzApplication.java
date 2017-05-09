package com.rachfal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:fb-applicationContext.xml")
public class FizzbuzzApplication {

    public static void main(String[] args) {

        SpringApplication.run(FizzbuzzApplication.class, args);
    }
}
