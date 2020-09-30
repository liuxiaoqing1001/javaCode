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
