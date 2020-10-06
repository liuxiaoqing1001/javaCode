package com.example.liu.news.service;

import com.example.liu.news.bean.Page;
import com.example.liu.news.entity.News;

import java.util.Date;
import java.util.List;

public interface NewsService {
    Page<News> newsPage(Integer typeid, String title, Date pubdate, Integer curPage, Integer size) ;
    News getById(Integer id) ;
    boolean add(News news) ;
    boolean delById(Integer id) ;
    boolean delByIds(List<Integer> ids) ;
    boolean updateById(News news) ;
}
