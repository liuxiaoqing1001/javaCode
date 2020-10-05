package com.example.liu.rest_ful.rest_ful_user.config;

import com.example.liu.rest_ful.rest_ful_user.interceptor.AuthorityInterceptor;
import com.example.liu.rest_ful.rest_ful_user.interceptor.StaticInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    StaticInterceptor staticInterceptor ;
    @Autowired
    AuthorityInterceptor authorityInterceptor ;
    String[] staticExclude = {"/admin/login" , "/assets/css/**" , "/assets/js/**" , "/assets/imgs/**" , "/js/**" , "/error/**"};
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorityInterceptor)
                .addPathPatterns("/admin/**" , "/system/**") ;
        registry.addInterceptor(staticInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(staticExclude) ;

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/templates/");
    }
}
