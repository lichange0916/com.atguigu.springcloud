package com.atguigu.springcloud.service.impl;

import com.atguigu.springboot.entity.Payment;
import com.atguigu.springcloud.dao.PaymentDao;

import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService
{
    @Resource
   private PaymentDao paymentDao;

    @Override
    public int createService(Payment payment) {
        return paymentDao.createDao(payment);
    }

    @Override
    public Payment getPaymentByIdService(Long id) {
        return paymentDao.getPaymentByIdDao(id);
    }
}
