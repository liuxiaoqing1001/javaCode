package com.example.liu.springboot_mybatis2;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.liu.springboot_mybatis2.dao.*;
import com.example.liu.springboot_mybatis2.dao.impl.NewsDaoPlusImpl;
import com.example.liu.springboot_mybatis2.entity.*;
import com.example.liu.springboot_mybatis2.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootTest
class SpringbootMybatis2ApplicationTests {

    @Autowired
    UserDao userDao;

//    测试类
    @Test
    void contextLoads() {
//        select 根据用户名和密码查找用户
        System.out.println(userDao.select("a","222"));

//        select 用户名是否存在
        System.out.println(userDao.nameSearch("张三"));

////        insert 添加用户
//        User user = new User();
//        user.setName("李四");
//        user.setPassword(DigestUtils.md5DigestAsHex("123".getBytes()));
//        user.setActivecode(UUID.randomUUID().toString().replaceAll("-",""));
//
//        System.out.println(userDao.add(user));

//        update 根据id，修改电话
        System.out.println(userDao.updateMobile(1 , "13890900909"));

//        select 邮箱是否存在
        System.out.println(userDao.emailSearch("123@123.com"));

//        select 根据id，验证密码    报错：
        System.out.println(userDao.identifyPwd(1,"123456"));

//        update 根据id，修改密码
        System.out.println(userDao.modifyPwd(1,"123456"));

////        update 根据id，修改头像url
//        System.out.println(userDao.modifyPhotourl(1,"./路径"));

//        update 根据id，修改状态
        System.out.println(userDao.modifyStatus(1,1));

//        根据用户名关键字，实现模糊查询   \转义字符
        System.out.println(userDao.getByName("小"));

//        分页方法一

//        查询用户表记录总数
        System.out.println(userDao.getCount());

//        返回限定个数行数据
//      Integer offset  跳过的行数
//      Integer rows    返回的行数
        System.out.println(userDao.getLimitRows(4,4));


    }


//  分页方法二   UserService
    @Autowired
    UserService userService ;

    @Test
    void testService() {
        System.out.println(userService.pageInfo(1 , 4));
        System.out.println(userService.pageInfo(3 , 4));

    }


    @Autowired
    User2Dao user2Dao;

    @Test
    void testUser2(){
////    解决方法1
////      通过使用别名
//        System.out.println(user2Dao.getAll());

////    解决方法2
////        使用@Results注解或者\<resultMap>来说明查询结果和成员的对应关系
//        System.out.println(user2Dao.getAll2());
//        System.out.println(user2Dao.getById(1));
    }


    @Autowired
    NewsDao newsDao;

    @Autowired
    NewsTypeDao newsTypeDao;

    @Test
    void testNews(){
        System.out.println(newsDao.getTop10ByTypeid(2));
        System.out.println(newsDao.getDetailById(1));
        System.out.println(newsDao.getById(2));

        System.out.println(newsTypeDao.getAll());

//        //连接 需要指明结果的映射方式
//        System.out.println(newsTypeDao.getDetailById(2));

        System.out.println(newsTypeDao.getDetailById2(2));

//        //多条select  通过@Results 或者 <resultMap> 来映射结果
        NewsType nType = newsTypeDao.getDetailById2(2) ;
        System.out.println(nType.getTypename());
        System.out.println(nType.getNewsList());
    }

    @Autowired
    UserMapper userMapper;

    @Test
    void testMapper(){
        System.out.println(userMapper.getByNameKey("小"));
        System.out.println(userMapper.delById(100));
    }


    //测试动态sql
    @Test
    void testSQL() throws ParseException {

//        测试动态sql <set>
        User user=new User();
        user.setId(6);
        user.setMobile("12300000");
        user.setStatus(1);
        user.setPhotourl("http://192.168.2.142/photourl/aa.png");
//        System.out.println(userDao.updateById(user));
//    多分支，最多只能修改一项
        System.out.println(userDao.updateById2(user));

        System.out.println(userDao.getByName2("小"));


////        测试动态sql <where>
//        System.out.println(newsDao.getMoreByWhere(null));//查询所有

        News news=new News();
        news.setTypeid(2);
//        news.setTitle("天");
//        System.out.println(newsDao.getMoreByWhere(news));
//        System.out.println("------------------------");
        news.setComefrom("头条");
//        测试动态sql <where>
        System.out.println(newsDao.getMoreByWhere(news));
//        System.out.println("------------------------");
//        News news2=new News();
//        news2.setPubdatetime(new SimpleDateFormat("yyyymmdd").parse("20200710"));
//        System.out.println(newsDao.getMoreByWhere(news2));

//        测试动态sql <trim>
        System.out.println(newsDao.getMoreByTrim(news));

////        foreach做批量插入
//        News news1=new News();
//        news1.setTypeid(3);
//        news1.setTitle("创新创维");
//        news1.setContent("保持环境卫生");
//        news1.setComefrom("QQ");
//        News news3=new News();
//        news3.setTypeid(4);
//        news3.setTitle("继续保持严格防控检查");
//        List<News> list=new ArrayList<>();
//        list.add(news1);
//        list.add(news3);
//        System.out.println(newsDao.addMore(list));

////        foreach批量删除
//        Integer[] ids={15,16};
//        System.out.println(newsDao.deleteMore(Arrays.asList(ids)));

    }

//    mybatis-plus
/*
    添加依赖项pom.xml
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus</artifactId>
            <version>3.4.0</version>
        </dependency>

    实体类注解使用
​		@TableName("表名") ==> 如果实体类名和表名不一致，需要使用该注解
​		@TableId 设置主键生成策略
​		@TableField ==》成员变量名和字段名不一致；如果数据表没有该成员对应的字段
*/

    @Autowired
    NewsDaoPlus newsDaoPlus;

    @Autowired
    NewsTypeDaoPlus newsTypeDaoPlus;

    @Test
    void testPlus(){
////        新增
//        NewsTypePlus newsTypePlus=new NewsTypePlus();
//        newsTypePlus.setTypename("天气");
//        System.out.println(newsTypeDaoPlus.insert(newsTypePlus));
//
////        修改
//        NewsTypePlus newsTypePlus1=new NewsTypePlus();
//        newsTypePlus1.setId(5);
//        newsTypePlus1.setTypename("网络综艺");
//        System.out.println(newsTypeDaoPlus.updateById(newsTypePlus1));

////        删除
//        // 根据id删除一条
//        System.out.println(newsTypeDaoPlus.deleteById(6));
//        // 根据id删除多条
//        System.out.println(newsTypeDaoPlus.deleteBatchIds(Arrays.asList(new Integer[]{6,7,8})));

////        查询
////        根据id查询一条，多条，查询总数量
//        System.out.println(newsTypeDaoPlus.selectById(5));
//        System.out.println(newsTypeDaoPlus.selectBatchIds(Arrays.asList(new Integer[]{1,3})));
//        System.out.println(newsTypeDaoPlus.selectCount(null));




//        条件构造器
//                ***AbstractWrapper

//                ***UpdateWrapper
        //根据新闻id更新content,comefrom
        UpdateWrapper<NewsPlus> wrapper=new UpdateWrapper<>();
        //set 设置更新字段以及值
        wrapper.set("id",10);
        wrapper.set("content","mybatis为简化单表CRUD而生");
        //设置where条件
        wrapper.eq("id",10);
        System.out.println(newsDaoPlus.update(null,wrapper));
        System.out.println("0000000000000000000000000");


//                  ***QueryWrapper
        QueryWrapper<NewsPlus> wrapper1=new QueryWrapper<>();
        wrapper1.select("id","title");
        System.out.println(newsDaoPlus.selectList(wrapper1));
        System.out.println("*****************");
        // where typeid=2
        wrapper1.clear();
        wrapper1.eq("typeid",2);
        System.out.println(newsDaoPlus.selectList(wrapper1));
        System.out.println("-------------------");
        // where title 含有小字，并且 typeid是2，3
        wrapper1.clear();
        wrapper1.like("title","小");
        wrapper1.in("typeid",new Integer[]{2,3});
        System.out.println(newsDaoPlus.selectList(wrapper1));
        System.out.println("/////////////////////");
        // where title 含有小字，或者来自 头条的消息
        wrapper1.clear();
        wrapper1.like("title","小").or().eq("comefrom" , "头条");
        System.out.println(newsDaoPlus.selectList(wrapper1));
    }


    @Autowired
    NewsDaoPlus newsDaoPlus1;

    @Test
    void testPlus2(){
        // 分页测试
        Page<NewsPlus> page = new Page<>(1,3) ;
        QueryWrapper<NewsPlus> wrapper = new QueryWrapper<>() ;
        wrapper.in("typeid" , new Integer[]{1,2,3}) ;
        newsDaoPlus1.selectPage(page , wrapper) ;
        System.out.println("本页数据 : " + page.getRecords());
        System.out.println("总页数 : " + page.getPages() + " , 总记录数 : " + page.getTotal());
        System.out.println("当前页 : " + page.getCurrent() + " ,每页记录数 : " + page.getSize());

    }


//    MyBatis Plus使用时dao层进一步封装
//      1）建议实体类中提供常量——数据表字段名映射常量
//​	    2）dao层创建派生类，描述所需要的数据库操作方法，在方法中封装Wrapper
//​	    3）以新闻表操作为例

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


//    MyBatis的缓存 [select]
//      1）一级缓存默认开启 【SqlSession级别--会话级别】
//        同一个SqlSession对象调用同一个Mapper或者Dao层的查询方法，而且传入参数相同，默认使用缓存。
//        如果调用了SqlSession的close或者clear方法，缓存将会被清空。
//      2）二级缓存，默认未开启【Application级别】
//         ①。MyBatis的配置文件中描述开启缓存
//         ②。mapper的xm文件中开启缓存

    @Autowired
    NewsDao newsDao1;

    @Test
    void testMyBatis(){
        System.out.println(newsDao1.getById(10));
        System.out.println(newsDao1.getById(10));
    }



}
