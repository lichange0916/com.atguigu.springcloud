package com.atguigu.springcloud.service;


import com.atguigu.springboot.entity.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService
{
    public int createService(Payment payment);

    public Payment getPaymentByIdService(@Param("id") Long id);
}
