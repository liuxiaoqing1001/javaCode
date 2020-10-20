package com.example.liu.productprovider.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "product")
@PropertySource(value = "classpath:application.properties" , encoding = "utf-8")
public class Product {
    private Integer id ;
    private String name;
    private double price;
    private String publishname;
    @JsonFormat(pattern = "yyyy年MM月dd日")
    private Date publishDate;
    private String author;
}
