package com.example.liu.rest_ful.rest_ful_user.entity;

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
//    JsonIgnore    返回的password信息不被序列化  获取密码为空
    @JsonIgnore
    private String password ;
//    凡是日期类型加DateTimeFormat和JsonFormat
    @DateTimeFormat(pattern = "yyyy年MM月dd日")
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm:ss" , timezone = "Asia/Shanghai")
    private Date regdatetime ;
    private Integer status ;
    private String photourl , email , mobile , activecode;
}
