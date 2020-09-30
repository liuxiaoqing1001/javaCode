package com.isoft.testmybatis.dao;

import com.isoft.testmybatis.entity.News;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * -- 根据新闻类别id，查看该类别下最新新闻前10条
 * -- 根据新闻id，查看新闻详细信息（新闻类别信息）
 * -- 根据新闻id，查看新闻信息（不包含新闻类别信息）
 */
@Mapper
public interface NewsDao {
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

    @Select("select * from tb_news where id=#{id}")
    public News getById(Integer id) ;

    /**
     * 多条件查询新闻信息
     * @param news，判断参数news的哪个属性不为空，然后作为查询条件
     *            id，typeid，title关键字，发布日期，新闻来源
     * @return
     */
    @Select("<script>" +
            "select * from tb_news" +
            "        <where>" +
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
            "        </where>"+
            "</script>")
    public List<News> getMoreBy(News news) ;

    /**
     * 多条件查询新闻信息
     * @param news，判断参数news的哪个属性不为空，然后作为查询条件
     *            id，typeid，title关键字，发布日期，新闻来源
     * @return
     */
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
            "        </trim>"+
            "</script>")
    public List<News> getMoreBy2(News news) ;


    /**
     * 批量插入
     * @param newsList
     * @return
     */
    @Insert("<script>" +
            "insert into tb_news values" +
            "        <foreach collection=\"list\" item=\"n\" separator=\",\">" +
            "            (null,#{n.typeid},#{n.title},#{n.content},now(),#{n.comefrom})" +
            "        </foreach>"
            +"</script>")
    int addMore(List<News> newsList) ;

    @Delete("<script>" +
            "        delete from tb_news where id in" +
            "        <foreach collection=\"list\" item=\"delid\" separator=\",\" open=\"(\"  close=\")\">" +
            "            #{delid}" +
            "        </foreach>"
            +"</script>")
    int delMore(List<Integer> idList) ;
}
