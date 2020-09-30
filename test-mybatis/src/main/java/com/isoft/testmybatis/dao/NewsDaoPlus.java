package com.isoft.testmybatis.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.isoft.testmybatis.entity.NewsPlus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface NewsDaoPlus extends BaseMapper<NewsPlus> {

    /**
     * 根据新闻id，查看新闻详细信息（新闻类别信息）
     * @param id
     * @return
     */
    @Select("select n.* , t.typename " +
            "from tb_news n inner join tb_newstype t " +
            "on n.typeid=t.id " +
            "where n.id=#{id}")
    public NewsDao getDetailById(Integer id) ;
}
