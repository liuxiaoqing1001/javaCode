package com.isoft.testmybatis.dao;

import com.isoft.testmybatis.entity.NewsType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 -- 查看所有新闻类别
 -- 查看所有新闻类别，以及该类别下最新新闻的前10条
 -- 根据新闻类别id，查看该类别详情，以及该类别下最新新闻的前10条
 */
@Mapper
public interface NewsTypeDao {
    @Select("select * from tb_newstype")
    List<NewsType> getAll() ;

    /**
     * 根据新闻类别id，查看该类别详情，以及该类别下最新新闻的前10条
     */
    @Select("select t.id as tid , t.typename , n.* " +
            "from tb_news n inner join tb_newstype t " +
            "on n.typeid=t.id " +
            "where n.typeid=#{typeId} " +
            "order by n.pubdatetime desc  " +
            "limit 0,10 ")
    @ResultMap("com.isoft.testmybatis.result.NewsTypeDetailMap")
    NewsType getDetailById(Integer typeId) ;

    @Select("select * from tb_newstype where id=#{typeid}")
    @Results({
            @Result(id = true , column = "id", property = "id") ,
            @Result(column = "typename" , property = "typename") ,
            @Result(property = "newsList", column = "id" , many = @Many(select = "com.isoft.testmybatis.dao.NewsDao.getTop10ByTypeid" , fetchType = FetchType.LAZY))
    })
    NewsType getDetailById2(Integer typeId) ;



}
