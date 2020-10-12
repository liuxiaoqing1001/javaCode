package com.example.liu.gatewayzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class PreRequestLogFilter extends ZuulFilter {
    //slf4j日志门面     spring
    //PreRequestLogFilter.class     .class反射
    private static final Logger LOGGER = LoggerFactory.getLogger(PreRequestLogFilter.class) ;
    /**
     * 设置过滤器类型 ：pre, route, post, error
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 根据返回的boolean值决定是否执行过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的逻辑描述
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        // 通过zuul，获取请求上下文
        RequestContext rc = RequestContext.getCurrentContext();
        HttpServletRequest request = rc.getRequest();

        //日志处理
        LOGGER.info("PreRequestLogFilter.....method={},url={}",
                request.getMethod(),request.getRequestURL().toString());
        /*
        // 可以记录日志、鉴权，给维护人员记录提供定位协助、统计性能
        // 访问权限 权限验证
        String accessToken = request.getHeader("accessToken") ;
        if(StringUtils.isEmpty(accessToken)) {
            LOGGER.info("当前请求没有accessToken") ;
            rc.setSendZuulResponse(false);
            rc.setResponseStatusCode(401);
            return null ;
        }
         */
        return null;
    }
}
