package com.example.liu.erekaprovider2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ErekaProvider2Application {

    public static void main(String[] args) {
        SpringApplication.run(ErekaProvider2Application.class, args);
    }

}
