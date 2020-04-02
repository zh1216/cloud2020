package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/4/2
 */
@Slf4j
@RestController
public class OrderConsulController {
	public static final String INVOKE_URL = "http://cloud-provider-payment-consul";

	@Resource
	RestTemplate restTemplate;

	@GetMapping("/consume/payment/consul")
	public String  paymentInfo(){
		return restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
	}
}
