package com.example.liu.news.dao;

import com.example.liu.news.entity.News;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NewsDao {
    @Select("select * from tb_news where id=#{id}")
    public News getById(Integer id) ;

    /**
     * 根据新闻类别id，查看该类别下最新新闻前10条
     * @param typeid
     * @return
     */
    @Select("select * from tb_news where typeid=#{typeid} order by pubdatetime desc limit 0,10")
    public List<News> getTop10ByTypeid(Integer typeid) ;

    /**
     * 根据新闻id，查看新闻详细信息（新闻类别信息）
     * @param id
     * @return
     */
    @Select("select n.* , t.typename " +
            "from tb_news n inner join tb_newstype t " +
            "on n.typeid=t.id " +
            "where n.id=#{id}")
    public News getDetailById(Integer id) ;


    /**
     * 多条件查询新闻信息
     * @param news，判断参数news的哪个属性不为空，然后作为查询条件
     *            id，typeid，title关键字，发布日期，新闻来源
     * @return
     */
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
    public List<News> getMoreBy(@Param("typeid") Integer typeid, @Param("title") String title, @Param("pubdatetime") String pubdate, @Param("offset") Integer offset, @Param("rows") Integer rows) ;

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
    public int getMoreCount(@Param("typeid") Integer typeid, @Param("title") String title, @Param("pubdatetime") String pubdate) ;

    @Insert("insert into tb_news values(null , #{typeid} , #{title} , #{content} ,now(),#{comefrom})")
    int add(News news) ;

    @Delete("<script>" +
            "        delete from tb_news where id in" +
            "        <foreach collection=\"list\" item=\"delid\" separator=\",\" open=\"(\"  close=\")\">" +
            "            #{delid}" +
            "        </foreach>"
            +"</script>")
    int delMore(List<Integer> idList) ;

    @Delete("delete from tb_news where id=#{id}")
    int delById(Integer id) ;

    @Update("<script>" +
            " update tb_news" +
            "        <set>" +
            "            <if test=\"null != content\">" +
            "                content=#{content} ," +
            "            </if>" +
            "            <if test=\"null != comefrom\">" +
            "                comefrom=#{comefrom} ," +
            "            </if>" +
            "        </set>" +
            "        where id=#{id}" +
            "</script>")
    int update(News news) ;
}
