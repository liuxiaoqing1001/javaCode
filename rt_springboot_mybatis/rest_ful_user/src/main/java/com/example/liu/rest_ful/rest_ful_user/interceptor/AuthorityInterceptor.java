package com.example.liu.rest_ful.rest_ful_user.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 后台以 /admin,/system 为路径前缀的请求，未经登录不允许访问
 * 后台登录成功，服务器端Session保存了 manUser 信息
 */
@Component
public class AuthorityInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession() ;
        if(null == session.getAttribute("manUser")) {
            response.sendRedirect(request.getContextPath() + "/manager/Login.html");
            return false;
        }
        return true ;
    }
}
