package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/3/27
 */
@Slf4j
@RestController
public class OrderController {

//	private static final String BASE_URL = "http://localhost:8001";
	// 地址不在写死，由服务名去注册中心获取真实ip,轮询调用
	private static final String BASE_URL = "http://CLOUD-PAYMENT-SERVICE";

	@Resource
	RestTemplate restTemplate;

	@GetMapping("/consume/payment/create")
	public CommonResult<Payment> create(Payment payment){
		return restTemplate.postForObject(BASE_URL+"/payment/create",payment,CommonResult.class);
	}

	@GetMapping("/consume/payment/get/{id}")
	public CommonResult<Payment> getPayment(@PathVariable("id") long id){
		return restTemplate.getForObject(BASE_URL+"/payment/get/"+id,CommonResult.class);
	}
}
