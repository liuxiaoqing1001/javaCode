package com.isoft.news.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@ConfigurationProperties(prefix = "person")
@PropertySource(value = "classpath:application-dev.properties" , encoding = "utf-8")
@Data
public class Person {
    private String name ;
    private String passWord ;

    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm:ss")
    private Date birth ;
}
