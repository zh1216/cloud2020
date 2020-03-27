package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/3/27
 */
public interface PaymentService {

	int create(Payment payment);

	Payment getPaymentById(Long id);
}
