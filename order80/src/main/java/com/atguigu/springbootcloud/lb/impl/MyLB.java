package com.atguigu.springbootcloud.lb.impl;

import com.atguigu.springbootcloud.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LoadBalancer
{
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement()
    {
        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("***********第几次访问,次数next" + next);
        return next;
    }
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstanceList)
    {
        //调用哪台机器 = 访问次数 % 第几次调用访问
        int index = getAndIncrement() % serviceInstanceList.size();
        //选择哪台服务器去运行
        return serviceInstanceList.get(index);
    }
}
