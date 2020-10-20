package com.example.liu.userprovider.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String name , password;
    private Date regdatetime;
    private Integer status;
    private String photourl , email , mobile , activecode ;
}
