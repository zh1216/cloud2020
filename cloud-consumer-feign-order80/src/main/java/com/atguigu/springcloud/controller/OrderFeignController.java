package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.feign.PaymentFeignClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/4/5
 */
@RestController
public class OrderFeignController {

	@Resource
	PaymentFeignClient paymentFeignClient;

	@GetMapping("/consume/payment/get/{id}")
	public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
		// Feign调用方式
		return paymentFeignClient.getPaymentById(id);
	}

	@GetMapping("/consume/payment/timeout")
	public String paymentTimeout(){
		return paymentFeignClient.paymentTimeout();
	}
}
