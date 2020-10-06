package com.isoft.news.dao;

import com.isoft.news.entity.NewsType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NewsTypeDao {
    @Select("select * from tb_newstype")
    List<NewsType> getAll() ;
}
