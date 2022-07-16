package com.atguigu.springcloud;

import com.sun.glass.ui.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //激活并开启feign
public class OrderFeignMan03 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMan03.class,args);
    }
}
