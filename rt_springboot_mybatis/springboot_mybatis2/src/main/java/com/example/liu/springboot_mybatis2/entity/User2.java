package com.example.liu.springboot_mybatis2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User2 {
    private Integer id ;
    private String uname , upass ;  //数据库中对应字段name，password
    private Date regdatetime ;
    private Integer status ;
    private String photourl , email , mobile , activecode;
}