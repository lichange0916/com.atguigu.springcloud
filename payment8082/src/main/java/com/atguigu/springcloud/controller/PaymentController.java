package com.atguigu.springcloud.controller;

import com.atguigu.springboot.entity.CommonResult;
import com.atguigu.springboot.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.netflix.discovery.DiscoveryClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController
{
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment)
    {
        int count = paymentService.createService(payment);
        log.info("****插入结果"+count);
        if (count>0){
            return new CommonResult(200,"插入数据库成功,服务器为:!"+serverPort,count);
        }else {
            return new CommonResult<>(444,"插入数据失败!",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult insert(@PathVariable("id") Long id)
    {
        Payment payment = paymentService.getPaymentByIdService(id);
        log.info("****查询结果"+payment);
        if (payment != null){
            return new CommonResult(200,"查询成功!服务器为:"+serverPort,payment);
        }else {
            return new CommonResult<>(444,"没有对应记录!",null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }

}
