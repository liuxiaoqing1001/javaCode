package com.example.liu.news.config;

import com.example.liu.news.interceptor.AuthorityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


// @Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    AuthorityInterceptor authorityInterceptor ;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorityInterceptor)
                .addPathPatterns("/admin/**" , "/system/**")
                .excludePathPatterns("/admin/login" , "/system/login");
    }
}
