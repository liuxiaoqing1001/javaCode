package com.isoft.testmybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.testmybatis.dao.*;
import com.isoft.testmybatis.dao.impl.NewsDaoPlusImpl;
import com.isoft.testmybatis.entity.NewsPlus;
import com.isoft.testmybatis.entity.User;
import com.isoft.testmybatis.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootTest
class TestMybatisApplicationTests {


    @Autowired
    NewsDaoPlusImpl nDao2 ;
    @Test
    void testPlus3() throws ParseException {
        NewsPlus n1 = new NewsPlus() ;
        n1.setId(10);
        n1.setTitle("下雨降温了");
        n1.setComefrom("大软A402");
        System.out.println(nDao2.update(n1));
        System.out.println("---------");
        System.out.println(nDao2.getById(10));
        System.out.println("----------");
        NewsPlus n2 = new NewsPlus() ;
        n2.setTypeid(2);
        n2.setPubdatetime(new SimpleDateFormat("yyyyMMdd").parse("20200710"));
        Page<NewsPlus> page = nDao2.getPage(1 , 3 , n2) ;
        System.out.println(page.getRecords());
    }

    @Autowired
    NewsDaoPlus newsDaoPlus ;
    @Test
    void testPlus2() {
        // 分页测试
        Page<NewsPlus> page = new Page<>(1,3) ;
        QueryWrapper<NewsPlus> wrapper = new QueryWrapper<>() ;
        wrapper.in("typeid" , new Integer[]{1,2,3}) ;
        newsDaoPlus.selectPage(page , wrapper) ;
        System.out.println("本页数据 : " + page.getRecords());
        System.out.println("总页数 : " + page.getPages() + " , 总记录数 : " + page.getTotal());
        System.out.println("当前页 : " + page.getCurrent() + " ,每页记录数 : " + page.getSize());

        /*
        // 根据新闻id，更新 content 与 comefrom
        UpdateWrapper<NewsPlus> wrapper = new UpdateWrapper<>() ;
        // set 设置更新字段以及值
        wrapper.set("content" , "mybatis-plus为简化单表CRUD而升") ;
        wrapper.set("comefrom" , "Idea") ;
        // 设置where条件
        wrapper.eq("id" , 10) ;
        System.out.println(newsDaoPlus.update(null , wrapper));
        */

        /*
        // QueryWrapper
        QueryWrapper<NewsPlus> wrapper = new QueryWrapper<>() ;
        wrapper.select("id" , "title") ;
        System.out.println(newsDaoPlus.selectList(wrapper));
        System.out.println("------------");
        // where typeid=2
        wrapper.clear();
        wrapper.eq("typeid" , 2) ;
        System.out.println(newsDaoPlus.selectList(wrapper));
        System.out.println("------------");
        // where title 含有小字，并且 typeid是2，3
        wrapper.clear();
        wrapper.like("title" , "小") ;
        wrapper.in("typeid" , new Integer[]{2,3}) ;
        System.out.println(newsDaoPlus.selectList(wrapper));
        // where title 含有小字，或者来自 头条的消息
        wrapper.clear();
        wrapper.like("title" , "小").or().eq("comefrom" , "头条") ;
        System.out.println(newsDaoPlus.selectList(wrapper));
         */
    }



    @Autowired
    NewsTypeDaoPlus newsTypeDaoPlus ;
    @Test
    void testPlus() {
        /*
        // 新增
        NewsTypePlus newsTypePlus = new NewsTypePlus();
        newsTypePlus.setTypename("天气");
        System.out.println(newsTypeDaoPlus.insert(newsTypePlus));
        System.out.println("----------");
        // 修改
        NewsTypePlus nt2 = new NewsTypePlus() ;
        nt2.setId(5);
        nt2.setTypename("网络综艺");
        System.out.println(newsTypeDaoPlus.updateById(nt2)) ;
        System.out.println("---------------");
        */
        /*
        // 根据id删除一条
        System.out.println(newsTypeDaoPlus.deleteById(6));
        // 根据id删除多条
        System.out.println(newsTypeDaoPlus.deleteBatchIds(Arrays.asList(new Integer[]{6,7,8})));
        */

        // 根据id查询一条，多条，查询总数量
        System.out.println(newsTypeDaoPlus.selectById(5));
        System.out.println(newsTypeDaoPlus.selectBatchIds(Arrays.asList(new Integer[]{1,3})));
        System.out.println(newsTypeDaoPlus.selectCount(null));
    }

    @Autowired
    UserMapper userMapper ;
    @Test
    void testMapper() {
        System.out.println(userMapper.getByNameKey("小"));
        System.out.println(userMapper.delById(100));
    }

    @Autowired
    NewsDao newsDao ;
    @Autowired
    NewsTypeDao newsTypeDao ;

    @Test
    void testNews() throws ParseException {
        System.out.println(newsDao.getById(10));
        System.out.println(newsDao.getById(10));
//        Integer[] ids = {11,12,15} ;
//        System.out.println(newsDao.delMore(Arrays.asList(ids)));

//        News n1 = new News() ;
//        n1.setTypeid(3);
//        n1.setTitle("创新创卫");
//        n1.setContent("保持环境卫生");
//        n1.setComefrom("QQ");
//        News n2 = new News() ;
//        n2.setTypeid(4);
//        n2.setTitle("继续保持严格防空检查");
//        List<News> list = new ArrayList<>() ;
//        list.add(n1) ; list.add(n2) ;
//        System.out.println(newsDao.addMore(list));

//        System.out.println(newsDao.getMoreBy(null));
//        System.out.println("--------");
//        News news = new News() ;
//        news.setTypeid(2);
//        news.setTitle("天");
//        System.out.println(newsDao.getMoreBy2(news));
//        System.out.println("---------");
//        news.setComefrom("头条");
//        System.out.println(newsDao.getMoreBy(news));
//        System.out.println("-------------");
//        News news2 = new News() ;
//        news2.setPubdatetime(new SimpleDateFormat("yyyyMMdd").parse("20200710"));
//        System.out.println(newsDao.getMoreBy(news2));
//        System.out.println(newsDao.getTop10ByTypeid(2));
//        System.out.println(newsDao.getDetailById(1));
//        System.out.println(newsDao.getById(2));
//        System.out.println(newsTypeDao.getDetailById(2));
//        System.out.println(newsTypeDao.getDetailById2(2));
//        NewsType nType = newsTypeDao.getDetailById2(2) ;
//        System.out.println(nType.getTypename());
//        System.out.println(nType.getNewsList());
    }



    @Autowired
    User2Dao user2Dao ;
    @Test
    void testUser2() {
//        System.out.println(user2Dao.getAll());
        System.out.println(user2Dao.getAll2());
        System.out.println(user2Dao.getById(1));
    }


    @Autowired
    UserDao userDao ;

    @Autowired
    UserService userService ;

    @Test
    void contextLoads() {
        User user = new User() ;
        user.setId(6);
        user.setMobile("13800000000");
        user.setStatus(1);
        user.setPhotourl("http://192.168.2.142/photourl/aa.png");
        System.out.println(userDao.updateById2(user));


//        System.out.println(userDao.select("张三" , "123"));
/*
        User user = new User();
        user.setName("张三");
        user.setPassword(DigestUtils.md5DigestAsHex("123".getBytes()));
        user.setActivecode(UUID.randomUUID().toString().replaceAll("-",""));

        System.out.println(userDao.add(user));
 */
//        System.out.println(userDao.updateMobile(1 , "13890900909"));
//        System.out.println(userDao.getByName("小"));
//        System.out.println(userDao.getCount());
//        System.out.println(userDao.getLimitRows(4,4)) ;


    }

    @Test
    void testService() {
        System.out.println(userService.pageInfo(1 , 4));
        System.out.println(userService.pageInfo(3 , 4));

    }
}
