package com.example.liu.springboot_mybatis2.dao;

import com.example.liu.springboot_mybatis2.entity.News;
import com.example.liu.springboot_mybatis2.entity.NewsType;
import com.example.liu.springboot_mybatis2.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface NewsDao {

//    NewsDao
//    -- 根据新闻类别id，查看该类别下最新新闻前10条
//    -- 根据新闻id，查看新闻详细信息（新闻类别信息）
//    -- 根据新闻id，查看新闻信息（不包含新闻类别信息）

    @Select("select * from tb_news where typeid=#{typeid} order by pubdatetime desc limit 0,10")
    public List<News> getTop10ByTypeid(Integer typeid);

    @Select("select n.*,t.typename from tb_news n inner join tb_type t " +
            "on n.typeid=t.id where n.id=#{id} ")
    public News getDetailById(Integer id);

    @Select("select * from tb_news where id=#{id}")
    public News getById(Integer id);


//    动态sql <where>     <set>在UserDao.java
//    批量查询

    /**
     * 多条件查询新闻信息
     * @param news  判断参数news的哪个属性不为空，然后作为查询条件
     *              id，typeid，title关键字，发布日期，新闻来源
     * @return
     */
    @Select("<script> " +
            "select * from tb_news" +
            "        <where>" +
            "            <if test=\"null!=id\">" +
            "                and id=#{id}" +
            "            </if>" +
            "            <if test=\"null!=typeid\">" +
            "                and typeid=#{typeid}" +
            "            </if>" +
            "            <if test=\"null!=title\">" +
            "                <bind name=\"titleKey\" value=\"'%'+title+'%'\"/>" +
            "                and title like #{titleKey}" +
            "            </if>" +
            "            <if test=\"null!=comefrom\">" +
            "                and comefrom=#{comefrom}" +
            "            </if>" +
            "            <if test=\"null!=pubdatetime\">" +
            "                and DATE_FORMAT(pubdatetime,'%Y%m%d')=DATE_FORMAT(#{pubdatetime},'%Y%m%d')" +
            "            </if>" +
            "        </where>" +
            "</script>")
    public List<News> getMoreByWhere(News news);

//    动态sql <trim>     <set>在UserDao.java
    @Select("<script>" +
            "select * from tb_news" +
            "        <trim prefix=\"where\" prefixOverrides=\"and\">" +
            "            <if test=\"null != id\">" +
            "                and id=#{id}" +
            "            </if>" +
            "            <if test=\"null != typeid\">" +
            "                and typeid=#{typeid}" +
            "            </if>" +
            "            <if test=\"null != title\">" +
            "                <bind name=\"titleKey\" value=\"'%'+title+'%'\" />" +
            "                    and title like #{titleKey}" +
            "            </if>" +
            "            <if test=\"null != comefrom\">" +
            "                and comefrom=#{comefrom}" +
            "            </if>" +
            "            <if test=\"null != pubdatetime\">" +
            "                and DATE_FORMAT(pubdatetime,'%Y%m%d')=DATE_FORMAT(#{pubdatetime},'%Y%m%d')" +
            "            </if>" +
            "        </trim>" +
            "</script>")
    public List<News> getMoreByTrim(News news);


//    批量插入
    /**
     * foreach做批量插入
     * @param newsList
     * @return
     */
    @Insert("<script>" +
            "insert into tb_news values" +
            "        <foreach collection=\"list\" item=\"n\" separator=\",\">" +
            "            (null,#{n.typeid},#{n.title},#{n.content},now(),#{n.comefrom})" +
            "        </foreach>" +
            "</script>")
    int addMore(List<News> newsList);

//     foreach批量删除
    /**
     * @param
     * @return
     */
    @Delete("<script>" +
            " delete from tb_news where id in " +
            "        <foreach collection=\"list\" item=\"delid\" separator=\",\" open=\"(\"  close= \")\">" +
            "            #{delid}" +
            "        </foreach>" +
            "</script>")
    int deleteMore(List<Integer> idList);

    @Delete("delete from tb_news where id=#{id}")
    int delByNewsId(Integer id) ;

//    测试前端WebStorm页面访问后端

    @Select("<script>" +
            "select * from tb_news" +
            "        <where>" +
            "            <if test=\"null != typeid\">" +
            "                and typeid=#{typeid}" +
            "            </if>" +
            "            <if test=\"null != title\">" +
            "                <bind name=\"titleKey\" value=\"'%'+title+'%'\" />" +
            "                    and title like #{titleKey}" +
            "            </if>" +
            "            <if test=\"null != pubdatetime\">" +
            "                and DATE_FORMAT(pubdatetime,'%Y%m%d')=#{pubdatetime}" +
            "            </if>" +
            "        </where>"+
            " order by pubdatetime desc limit #{offset},#{rows}" +
            "</script>")
    //参数多个的时候使用@Param("")注解
    public List<News> getMoreBy(@Param("typeid") Integer typeid , @Param("title") String title , @Param("pubdatetime") Date pubdate, @Param("offset") Integer offset , @Param("rows") Integer rows) ;

    @Select("<script>" +
            "select count(*) from tb_news" +
            "        <where>" +
            "            <if test=\"null != typeid\">" +
            "                and typeid=#{typeid}" +
            "            </if>" +
            "            <if test=\"null != title\">" +
            "                <bind name=\"titleKey\" value=\"'%'+title+'%'\" />" +
            "                    and title like #{titleKey}" +
            "            </if>" +
            "            <if test=\"null != pubdatetime\">" +
            "                and DATE_FORMAT(pubdatetime,'%Y%m%d')=#{pubdatetime}" +
            "            </if>" +
            "        </where>"+
            "</script>")
    public int getMoreCount(@Param("typeid") Integer typeid , @Param("title") String title , @Param("pubdatetime") Date pubdate) ;


    @Insert("insert into tb_news values(null , #{typeid} , #{title} , #{content} ,now(),#{comefrom})")
    int addNews(News news) ;

//    动态sql新闻    测试前端WebStorm页面访问后端
    @Update("<script>" +
            "update tb_news" +
            "        <set>" +
            "            <if test=\"null!=content\">" +
            "                content=#{content}," +
            "            </if>" +
            "            <if test=\"null!=comefrom\">" +
            "                comefrom=#{comefrom}" +
            "            </if>" +
            "        </set>" +
            "        where id=#{id}" +
            "</script>")
    int updateNews(News news);

}
