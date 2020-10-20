package com.example.liu.userprovider;

import com.example.liu.userprovider.dao.UserDao;
import com.example.liu.userprovider.entity.User;
import com.example.liu.userprovider.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserProviderApplicationTests {

////    1 dao
//   @Autowired
//    UserDao userDao;

//    2 service
    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
////        1 dao
//        User u=new User();
//        u.setName("考试");
//        u.setPassword("123");
//        System.out.println(userDao.add(u));
//        System.out.println(userDao.login("考试","123"));

//        2 service
        System.out.println(userService.login("rose","123"));

    }

}
