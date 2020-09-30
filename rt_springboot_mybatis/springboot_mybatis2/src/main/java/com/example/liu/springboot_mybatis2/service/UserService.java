package com.example.liu.springboot_mybatis2.service;

import com.example.liu.springboot_mybatis2.bean.Page;
import com.example.liu.springboot_mybatis2.dao.UserDao;
import com.example.liu.springboot_mybatis2.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
//    用户信息分页
//        分页信息：
//            本页数据
//            总记录个数
//            总页数
//            当前第几页
//            每页记录个数
//
//    public ? pageInfo(Integer page , Integer size) {
//
//    }
//
//    Service层返回分页信息--需要一种数据类型保存 ==> Page<T>
//    Dao层 ==> 查询本页数据、记录个数

    @Autowired
    UserDao userDao ;

    /**
     * 分页查看用户数据
     * @param page 页码
     * @param size 每页记录个数
     */
    public Page<User> pageInfo(Integer page , Integer size) {
        if(null == page || page < 1) {
            page = 1 ;
        }
        if(null == size || size < 1) {
            size = 10 ;
        }
        int rowCount = userDao.getCount() ;
        ArrayList<User> data = (ArrayList<User>) userDao.getLimitRows((page-1)*size , size);
        int pageCount = (int) Math.ceil(rowCount * 1.0 / size);
        Page<User> pageInfo = new Page<>(data , page , rowCount , size , pageCount) ;
        return pageInfo ;
    }
}
