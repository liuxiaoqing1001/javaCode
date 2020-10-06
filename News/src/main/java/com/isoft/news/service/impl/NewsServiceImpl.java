package com.isoft.news.service.impl;

import com.isoft.news.bean.Page;
import com.isoft.news.dao.NewsDao;
import com.isoft.news.entity.News;
import com.isoft.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsDao newsDao ;

    /**
     *
     * @param typeid
     * @param title
     * @param pubdate
     * @param curPage
     * @param size
     * @return
     */
    @Override
    public Page<News> newsPage(Integer typeid , String title , Date pubdate, Integer curPage, Integer size) {
        if(null == curPage || curPage < 1) {
            curPage = 1 ;
        }
        if(null == size || size < 1) {
            size = 10 ;
        }
        String pubdateStr = null ;
        if(null != pubdate) {
            pubdateStr = new SimpleDateFormat("yyyyMMdd").format(pubdate) ;
        }
        List<News> list = newsDao.getMoreBy(typeid , title , pubdateStr , size * (curPage-1) , size) ;
        int count = newsDao.getMoreCount(typeid , title , pubdateStr) ;
        int pageCount = (int) Math.ceil(count * 1.0 / size);
        Page<News> pageInfo = new Page() ;
        pageInfo.setData((ArrayList<News>) list);
        pageInfo.setCurPage(curPage);
        pageInfo.setPageCount(pageCount);
        pageInfo.setRowCount(count) ;
        pageInfo.setSize(size);
        return pageInfo ;
    }

    @Override
    public News getById(Integer id) {
        if(null == id || id < 1) {
            return null ;
        }
        return newsDao.getById(id);
    }

    @Override
    public boolean add(News news) {
        if(null == news || news.getTitle() == null) {
            return false ;
        }
        return newsDao.add(news) > 0;
    }

    @Override
    public boolean delById(Integer id) {
        if(null == id || id < 1) {
            return false ;
        }
        return newsDao.delById(id) > 0;
    }

    @Override
    public boolean delByIds(List<Integer> ids) {
        if(null == ids || ids.size() < 1) {
            return false;
        }
        return newsDao.delMore(ids) > 0 ;
    }

    @Override
    public boolean updateById(News news) {
        if(null == news || news.getId() == null || news.getId() < 1) {
            return false ;
        }
        if(news.getContent() == null && news.getComefrom() == null) {
            return false ;
        }
        return newsDao.update(news) > 0;
    }
}
