package com.atguigu.springcloud.controller;

import com.atguigu.springboot.entity.CommonResult;
import com.atguigu.springboot.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController
{
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping(value="/payment/discovery")
    public Object discovery()
    {
        List<String> services = discoveryClient.getServices(); //获取微服务列表
        for (String element : services)
        {
            log.info("******element"+element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("Payment");//获取微服务名称
        for (ServiceInstance instance : instances)
        {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getUri()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeOut()
    {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
