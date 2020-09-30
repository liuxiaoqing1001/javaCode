package com.example.liu.springboot_mybatis2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class News implements Serializable {

    private Integer id,typeid;
    private String title,content;
    private Date pubdatetime;
    private String comefrom;

//    该属性来自tb_newstype表

    private String typename;

    public void getPubdatetime(Date yyyymmdd) {
    }
}
