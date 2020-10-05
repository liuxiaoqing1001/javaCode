package com.example.liu.rest_ful.rest_ful_user.service.impl;

import com.example.liu.rest_ful.rest_ful_user.dao.UserDao;
import com.example.liu.rest_ful.rest_ful_user.entity.User;
import com.example.liu.rest_ful.rest_ful_user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

//sql
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao ;
    @Override
    public Map<String, Object> loginCheck(String name, String pwd) {
        Map<String , Object> map = new HashMap<>() ;
        //账号密码是否为空
        if(StringUtils.isEmpty(name) || StringUtils.isEmpty(pwd)) {
            map.put(KEY_MSG , LOGIN_MSG_FAIL_OTHER) ;
            return map ;
        }
        // 先进行账号是否存在检测
        int nameCount = userDao.nameSearch(name) ;
        if(nameCount == 0) {
            map.put(KEY_MSG , LOGIN_MSG_FAIL_NON) ;
            return map ;
        }
        // 账号存在，登录检查
        User u = userDao.select(name , DigestUtils.md5DigestAsHex(pwd.getBytes())) ;
        if(u == null) {
            map.put(KEY_MSG , LOGIN_MSG_FAIL_ERROR) ;
            return map ;
        }
        map.put(KEY_USER , u) ;
        map.put(KEY_MSG , LOGIN_MSG_OK) ;
        return map;
    }

    @Override
    public Integer register(User user) {
        if(null == user) {
            return REG_MSG_FAIL_INFO_NON ;
        }
        if(StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(user.getPassword())) {
            return REG_MSG_FAIL_INFO_NON ;
        }
        // 先进行账号是否存在检测
        int nameCount = userDao.nameSearch(user.getName()) ;
        if(nameCount > 0) {
            return REG_MSG_FAIL_NAMEEXISTS ;
        }
        // 注册
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        int r = userDao.add(user) ;
        if(r > 0) {
            return REG_MSG_OK ;
        } else {
            return REG_MSG_FAIL_OTHER ;
        }
    }

    @Override
    public User update(User user) {
        if(null == user) {
            return null ;
        }
        if(user.getId() == null || user.getId() < 1) {
            return null ;
        }
        if(user.getMobile() == null && user.getPassword() == null && user.getStatus() == null && user.getPhotourl() == null) {
            return null ;
        }
        //对密码进行加密
        if(null != user.getPassword()) {
            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        }
        int r = userDao.updateById(user) ;
        if(r != 1) {
            return null ;
        } else {
            return userDao.getById(user.getId()) ;
        }
    }
}
