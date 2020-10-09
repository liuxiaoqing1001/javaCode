package com.example.liu.eurekaconsumerfeign.service;

import com.example.liu.eurekaconsumerfeign.entity.User;
import com.example.liu.eurekaconsumerfeign.hystrix.HystrixServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//在需要发送远程访问其他组件的Service的接口进行处理
//①。创建Service接口的实现类，类中方法的方法体为熔断开启后要执行的逻辑处理
//②。在Service接口的@FeignClient中设置属性 fallback=Service熔断器派生类.class

@Component
// name是要访问的provider的application-name
// fallback 服务降级
// 五种情况：
//    执行超时
//    执行过程抛出异常
//    断路器打开状态
//    线程池拒绝（池满后的拒绝策略）
//    信号量拒绝（信号量耗完）
@FeignClient(name = "eureka-provider",fallback = HystrixServiceImpl.class)
public interface HystrixService {
    @GetMapping("/ribbon/port")
    public String getPort();

    @GetMapping("/ribbon/{uid}")
    public User getById(@PathVariable("uid")Integer id);
}
