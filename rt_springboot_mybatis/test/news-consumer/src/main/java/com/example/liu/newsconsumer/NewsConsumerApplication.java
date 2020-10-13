package com.example.liu.newsconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class NewsConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsConsumerApplication.class, args);
    }

}
