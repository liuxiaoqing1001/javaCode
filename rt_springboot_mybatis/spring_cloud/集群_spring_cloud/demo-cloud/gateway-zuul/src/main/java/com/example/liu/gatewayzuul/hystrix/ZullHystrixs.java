package com.example.liu.gatewayzuul.hystrix;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

//Zuul和Hystrix的结合实现熔断
/*
    Zuul和Hystrix结合使用实现熔断功能时，
    需要实现**FallbackProvider**接口，在网关项目gateway-zuul中创建网关处理类MyFallbackProvider类，用于处理回退逻辑
    并实现FallbackProvider中的两个抽象方法,包括getRoute ()、 fallbackResponse ()。
*/

//停止provider时发生熔断，降级

//Component 生成对象
@Component
public class ZullHystrixs implements FallbackProvider {
    /**
     * return - 返回fallback处理哪一个服务。返回的是服务的名称
     * 推荐 - 为指定的服务定义特性化的fallback逻辑。
     * 推荐 - 提供一个处理所有服务的fallback逻辑。
     * 好处 - 服务某个服务发生超时，那么指定的fallback逻辑执行。如果有新服务上线，未提供fallback逻辑，有一个通用的。
     */
    @Override
    public String getRoute() {
        //为eureka-ribbon-consumer进行熔断处理
        return "eureka-ribbon-consumer";
//        return "*" ;  为每一个微服务提供降级处理
    }


    //降级处理
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return this.getStatusCode().value();
            }

            @Override
            public String getStatusText() throws IOException {
                return this.getStatusCode().getReasonPhrase();
            }

            @Override
            public void close() {
            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("连接异常，发生降级".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders header = new HttpHeaders() ;
                MediaType mediaType = new MediaType("application" , "json" , Charset.forName("UTF-8")) ;
                header.setContentType(mediaType);
                return header;
            }
        };
    }
}
