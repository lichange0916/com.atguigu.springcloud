package com.atguigu.springbootcloud;

import com.atguigu.MySelfRule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@EnableEurekaClient
@SpringBootApplication
@RibbonClient(name = "payment",configuration = MySelfRule.class)
public class Order80Main
{
    public static void main(String[] args)
    {
        SpringApplication.run(Order80Main.class,args);
    }
}
