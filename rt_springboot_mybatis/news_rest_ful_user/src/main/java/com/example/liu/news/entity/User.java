package com.example.liu.news.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private Integer id ;
    private String name ;
     @JsonIgnore
    private String password ;
    @DateTimeFormat(pattern = "yyyy年MM月dd日")
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm:ss" , timezone = "Asia/Shanghai")
    private Date regdatetime ;
    private Integer status ;
    private String photourl , email , mobile , activecode;
}
