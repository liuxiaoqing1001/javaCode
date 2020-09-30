package com.example.liu.springboot_mybatis2.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.liu.springboot_mybatis2.dao.NewsDaoPlus;
import com.example.liu.springboot_mybatis2.entity.NewsPlus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

//MyBatis Plus使用时dao层进一步封装

//dao层的实现

//@Component主件
@Component
public class NewsDaoPlusImpl {
    @Autowired
    NewsDaoPlus newsDaoPlus ;

    /**
     * 更新操作
     */
    public int update(NewsPlus newsPlus) {
        return newsDaoPlus.updateById(newsPlus) ;
    }

    /**
     * 根据新闻id，查看新闻详细信息（新闻类别信息）
     * @param id
     * @return
     */
    public NewsPlus getById(Integer id) {
        return newsDaoPlus.selectById(id) ;
    }

    /**
     * 多条件查询新闻信息,，并分页
     * @param news，判断参数news的哪个属性不为空，然后作为查询条件
     *            id，typeid，title关键字，发布日期，新闻来源
     * @return
     */
    public Page<NewsPlus> getPage(Integer pageCur , Integer size , NewsPlus news) {
        QueryWrapper<NewsPlus> wrapper = new QueryWrapper<>() ;
        if(null != news) {
            if (null != news.getTypeid()) {
                wrapper.eq(NewsPlus.COLUMN_TYPE_ID, news.getTypeid());
            }
            if (null != news.getTitle()) {
                wrapper.like(NewsPlus.COLUMN_TITLE, news.getTitle());
            }
            if (null != news.getPubdatetime()) {
                String pt = new SimpleDateFormat("yyyyMMdd").format(news.getPubdatetime()) ;
                wrapper.eq("date_format(" + NewsPlus.COLUMN_PUBDATETIME + " , '%Y%m%d')", pt);
            }
        }
        wrapper.orderByDesc(NewsPlus.COLUMN_PUBDATETIME) ;
        Page<NewsPlus> page = new Page<>(pageCur , size) ;
        newsDaoPlus.selectPage(page , wrapper) ;
        return page ;
    }
}
