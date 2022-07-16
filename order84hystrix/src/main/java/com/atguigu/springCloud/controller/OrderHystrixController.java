package com.atguigu.springCloud.controller;

import com.atguigu.springCloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController
{
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id)
    {
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }


    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeoutFallbackMethod",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "10000")
//    })
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id)
    {
        int age=10/0;
        String result= paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }

    public String paymentTimeoutFallbackMethod(@PathVariable("id") Integer id)
    {
        return "我是消费者8004，对方支付系统繁忙请10秒钟之后再试或者自己运行出错请检查自己/(ㄒoㄒ)/~~";
    }

    //下面是全局fallback
    public String payment_Global_FallbackMethod()
    {
        return "Global处理信息异常，请稍后再试!/(ㄒoㄒ)/~~";
    }
}
