package com.example.liu.news.service.impl;

import com.example.liu.news.dao.NewsTypeDao;
import com.example.liu.news.entity.NewsType;
import com.example.liu.news.service.NewstypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//NewstypeService的实现类

@Service
public class NewstypeServiceImpl implements NewstypeService {
    @Autowired
    NewsTypeDao newsTypeDao ;
    @Override
    public List<NewsType> getAll() {
        return newsTypeDao.getAll();
    }
}
