package com.example.liu.springboot_mybatis2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tb_news")
public class NewsPlus {

//    MyBatis Plus使用时dao层进一步封装
//    将tb_news表中所有列名都映射为常量
    public static final String COLUMN_ID = "id" ;
    public static final String COLUMN_TYPE_ID = "typeid" ;
    public static final String COLUMN_TITLE = "title" ;
    public static final String COLUMN_CONTENT = "content" ;
    public static final String COLUMN_PUBDATETIME = "pubdatetime" ;
    public static final String COLUMN_COMEFROM = "comefrom" ;


    @TableId(type = IdType.AUTO)
    private Integer id ;
    private Integer typeid ;
    private String title , content ;
    private Date pubdatetime ;
    private String comefrom ;
    /**
     * 该属性来自 tb_newstype表
     */
    @TableField(exist = false)
    private String typename ;
}
