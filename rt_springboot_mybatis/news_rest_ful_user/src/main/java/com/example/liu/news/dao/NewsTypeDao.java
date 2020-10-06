package com.example.liu.news.dao;

import com.example.liu.news.entity.NewsType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NewsTypeDao {
    @Select("select * from tb_type")
    List<NewsType> getAll() ;
}
