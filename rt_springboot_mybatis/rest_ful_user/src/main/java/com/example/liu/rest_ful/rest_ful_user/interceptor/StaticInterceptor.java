package com.example.liu.rest_ful.rest_ful_user.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 对静态资源请求，DispatcherServlet不进行任何的处理，直接查找资源，返回给客户端
 */
@Component
public class StaticInterceptor extends HandlerInterceptorAdapter {
}
