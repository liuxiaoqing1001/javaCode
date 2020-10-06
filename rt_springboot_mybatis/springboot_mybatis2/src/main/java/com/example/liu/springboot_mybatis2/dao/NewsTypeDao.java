package com.example.liu.springboot_mybatis2.dao;

import com.example.liu.springboot_mybatis2.entity.NewsType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface NewsTypeDao {

//    NewsTypeDao
//    -- 查看所有新闻类别
//    -- 根据新闻类别id，查看该类别，以及该类别下最新新闻的前10条
//        两种实现方式 ：①。连接； ==> 需要描述 <resultMap> 指明结果映射方式
//					 ②。多条select  ==> 通过@Results 或者 <resultMap> 来映射结果

    @Select("select * from tb_type")
    List<NewsType> getAll();

//    连接，实现多表信息查询
    @Select("select t.id as tid,t.typename,n.* " +
            "from tb_news n inner join tb_type t on n.typeid=t.id " +
            "where n.typeid=#{typeid} order by n.pubdatetime desc limit 0,10")
    @ResultMap("com.example.liu.springboot_mybatis2.result.NewsTypeDetailMap")
    NewsType getDetailById(Integer typeid);


//    多条select实现多表信息查询
    @Select("select * from tb_type where id=#{typeid}")
    @Results({
            @Result(id = true , column = "id", property = "id") ,
            @Result(column = "typename" , property = "typename") ,
            @Result(property = "newsList", column = "id" , many = @Many(select = "com.example.liu.springboot_mybatis2.dao.NewsDao.getTop10ByTypeid" , fetchType = FetchType.LAZY))
    })
    NewsType getDetailById2(Integer typeId) ;

}
