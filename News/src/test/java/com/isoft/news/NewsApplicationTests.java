package com.isoft.news;

import com.isoft.news.dao.NewsDao;
import com.isoft.news.entity.News;
import com.isoft.news.entity.User;
import com.isoft.news.service.NewsService;
import com.isoft.news.service.NewstypeService;
import com.isoft.news.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@SpringBootTest
class NewsApplicationTests {
    @Autowired
    NewsDao newsDao ;
    @Test
    void testNewsDao() throws ParseException {
//        News n = new News() ;
//        n.setContent("conten....t");
//        n.setComefrom("QQQ");
//        n.setId(11);
//        System.out.println(newsDao.add(n));
//        System.out.println(newsDao.getById(1));

//        System.out.println(newsDao.update(n));
//        System.out.println(newsDao.delById(12));
        News n2 = new News();

        n2.setPubdatetime(new SimpleDateFormat("yyyyMMdd").parse("20200710"));
        System.out.println(newsDao.getMoreBy(null,null , "20200710", 2 , 2));
        System.out.println(newsDao.getMoreCount(null,null , "20200710"));
    }

    @Autowired
    NewsService newsService ;
    @Test
    void testNewsService() throws ParseException {
        System.out.println(newsService.newsPage(null , null , new SimpleDateFormat("yyyyMMdd").parse("20200710") , 2 , 3));
        System.out.println(newsService.getById(2));
        News n = new News() ;
        n.setTitle("test2");
        n.setContent("c.........onten....t");
        n.setComefrom("头条");
        System.out.println(newsService.add(n));
       // System.out.println(newsService.delById(11));
        n.setId(12);
        n.setContent("000000000000000");
        System.out.println(newsService.updateById(n));
    }

    @Autowired
    NewstypeService newstypeService ;
    @Test
    void testNewsType() {
        System.out.println(newstypeService.getAll());
    }


    @Autowired
    UserService userService ;

    @Test
    void contextLoads() {
//        System.out.println(userService.loginCheck("aa" , "123"));
//        System.out.println(userService.loginCheck("rose" , "111"));
//        System.out.println(userService.loginCheck("rose" , "123"));

//        System.out.println(userService.register(null));
//        User u1 = new User() ;
//        u1.setName("aaa");
//        System.out.println(userService.register(u1));
//        u1.setName("rose");
//        u1.setPassword("123");
//        System.out.println(userService.register(u1));
//        u1.setName("aaa");
//        System.out.println(userService.register(u1));

        User u2 = new User() ;
        System.out.println(userService.update(u2));
        u2.setId(10);
        System.out.println(userService.update(u2));
        u2.setMobile("1387654321");
        System.out.println(userService.update(u2));
        u2.setMobile(null);
        u2.setPassword("321");
        System.out.println(userService.update(u2));
        u2.setPassword(null);
        u2.setStatus(1);
        System.out.println(userService.update(u2));
        u2.setStatus(null);
        u2.setPhotourl("hhhhhh");
        System.out.println(userService.update(u2));


    }

}
