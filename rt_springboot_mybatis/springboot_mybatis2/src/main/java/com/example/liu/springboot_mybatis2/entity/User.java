package com.example.liu.springboot_mybatis2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id ;
    private String name , password ;
    private Date regdatetime ;
    private Integer status ;
    private String photourl , email , mobile , activecode;
}