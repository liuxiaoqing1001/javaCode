package com.isoft.testmybatis.service;

import com.isoft.testmybatis.bean.Page;
import com.isoft.testmybatis.dao.UserDao;
import com.isoft.testmybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
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
