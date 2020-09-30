package com.isoft.testmybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.ArrayList;

@Data
@TableName("tb_newstype")
public class NewsTypePlus {
    @TableId(type = IdType.AUTO)        // 设置主键生成测率，IdType.AUTO使用数据库中设置的主键生成策略
    private Integer id ;
    @TableField(value = "typename")    // 成员变量名和字段名一致，可以不使用该属性
    private String typename ;

    @TableField(exist = false)         // 数据表没有news_list字段
    private ArrayList<News> newsList ;
}
