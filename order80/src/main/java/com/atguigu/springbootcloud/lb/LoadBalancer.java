package com.atguigu.springbootcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalancer
{
    //机器总数
    ServiceInstance instances(List<ServiceInstance> serviceInstanceList);
}
