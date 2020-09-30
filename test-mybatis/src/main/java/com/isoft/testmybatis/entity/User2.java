package com.isoft.testmybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User2 implements Serializable {
    private Integer id ;
    private String uname , upass ;
    private Date regdatetime ;
    private Integer status ;
    private String photourl , email , mobile , activecode;
}
