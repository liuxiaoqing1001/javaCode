package com.example.liu.userprovider.service;

import com.example.liu.userprovider.dao.UserDao;
import com.example.liu.userprovider.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserService {
    @Autowired
    UserDao userDao ;

    public User login(String name , String password){
        return userDao.login(name , DigestUtils.md5DigestAsHex(password.getBytes())) ;
    }

    public boolean register(User user) {
        if(null == user) {
            return false ;
        }
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        return userDao.add(user) > 0 ;
    }
}
