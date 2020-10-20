package com.example.liu.productconsumer.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer id ;
    private String name;
    private double price;
    private String publishname;
    @JsonFormat(pattern = "yyyy年MM月dd日")
    private Date publishDate;
    private String author;
}

