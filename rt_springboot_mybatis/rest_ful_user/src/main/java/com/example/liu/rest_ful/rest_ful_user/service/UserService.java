package com.example.liu.rest_ful.rest_ful_user.service;

import com.example.liu.rest_ful.rest_ful_user.entity.User;

import java.util.Map;

//sql
public interface UserService {
    //静态常量
    public static final int REG_MSG_OK = 0 ;//信息正确
    public static final int REG_MSG_FAIL_NAMEEXISTS = 1 ;//信息已存在
    public static final int REG_MSG_FAIL_INFO_NON = 2 ; //信息为空或不完整
    public static final int REG_MSG_FAIL_OTHER = 3 ;//

    String KEY_USER = "User" ;
    String KEY_MSG = "Msg" ;
    int LOGIN_MSG_OK = 0 ;//成功
    int LOGIN_MSG_FAIL_NON = 1 ;//账号不存在
    int LOGIN_MSG_FAIL_ERROR = 2 ;//信息错误/密码错误
    int LOGIN_MSG_FAIL_OTHER = 3 ;//
    /**
     *
     * @param name  非空
     * @param pwd  非空
     * @return  key--User , key-msg ; 其中 key-msg的值 0-成功；1-账号不存在；2-用户名或密码错误；3-登录失败
     */
    Map<String , Object> loginCheck(String name , String pwd) ;

    /**
     *
     * @param user 非空，名字和密码非空
     * @return Integer ：0--成功；1--用户名已存在；2--信息不完整；3--失败，其他原因
     */
    Integer register(User user) ;

    /**
     * 根据id修改个人信息，可以修改 电话、头像、状态、密码
     * @param user 非空，id非空，mobile、photoutl、status、password 至少一项不为空
     * @return
     */
    User update(User user) ;
}
