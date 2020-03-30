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
 *@date: 2020/3/30
 */
@RestController
@Slf4j
public class OrderZkController {

	public static final String INVOKE_URL = "http://cloud-provider-payment";

	@Resource
	RestTemplate restTemplate;

	@GetMapping("/consume/payment/zk")
	public String  paymentInfo(){
		return restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
	}
}
