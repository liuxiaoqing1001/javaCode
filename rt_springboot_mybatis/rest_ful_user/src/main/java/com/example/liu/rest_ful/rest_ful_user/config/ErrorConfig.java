package com.example.liu.rest_ful.rest_ful_user.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

// @Configuration
public class ErrorConfig {
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                //请求失败
                ErrorPage errorPage_400 = new ErrorPage(HttpStatus.BAD_REQUEST , "/errorpages/400.html") ;
                //找不到
                ErrorPage errorPage_404 = new ErrorPage(HttpStatus.NOT_FOUND , "/errorpages/404.html") ;
                //服务器内部错误
                ErrorPage errorPage_500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR , "/errorpages/500.html") ;
                factory.addErrorPages(errorPage_400 , errorPage_404, errorPage_500);
            }
        } ;
    }
}
