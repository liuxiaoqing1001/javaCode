package com.isoft.news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class NewsApplication  extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(NewsApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(NewsApplication.class);
    }

}
