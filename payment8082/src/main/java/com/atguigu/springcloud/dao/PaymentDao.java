package com.atguigu.springcloud.dao;


import com.atguigu.springboot.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao
{
    public int createDao(Payment payment);

    public Payment getPaymentByIdDao(@Param("id") Long id);
}
