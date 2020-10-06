package com.isoft.news.service.impl;

import com.isoft.news.dao.NewsTypeDao;
import com.isoft.news.entity.NewsType;
import com.isoft.news.service.NewstypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewstypeServiceImpl implements NewstypeService {
    @Autowired
    NewsTypeDao newsTypeDao ;
    @Override
    public List<NewsType> getAll() {
        return newsTypeDao.getAll();
    }
}
