package com.example.liu.springboot_mybatis2.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.liu.springboot_mybatis2.entity.NewsTypePlus;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsTypeDaoPlus extends BaseMapper<NewsTypePlus> {
}
