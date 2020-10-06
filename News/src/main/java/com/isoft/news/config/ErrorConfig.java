package com.isoft.news.config;

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
                ErrorPage errorPage_400 = new ErrorPage(HttpStatus.BAD_REQUEST , "/errorpages/400.html") ;
                ErrorPage errorPage_404 = new ErrorPage(HttpStatus.NOT_FOUND , "/errorpages/404.html") ;
                ErrorPage errorPage_500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR , "/errorpages/500.html") ;
                factory.addErrorPages(errorPage_400 , errorPage_404, errorPage_500);
            }
        } ;
    }
}
