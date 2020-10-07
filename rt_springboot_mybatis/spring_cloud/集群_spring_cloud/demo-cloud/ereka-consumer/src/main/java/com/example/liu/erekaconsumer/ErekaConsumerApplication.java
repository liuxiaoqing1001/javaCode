package com.example.liu.erekaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ErekaConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErekaConsumerApplication.class, args);
    }

}
