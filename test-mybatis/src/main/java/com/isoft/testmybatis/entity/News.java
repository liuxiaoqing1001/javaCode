package com.isoft.testmybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class News implements Serializable {
    private Integer id , typeid ;
    private String title , content ;
    private Date pubdatetime ;
    private String comefrom ;
    /**
     * 该属性来自 tb_newstype表
     */
    private String typename ;
}
