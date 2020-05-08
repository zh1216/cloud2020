package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/5/8
 */
@RestController
@Slf4j
public class ConsumeController {

	@Resource
	private RestTemplate restTemplate;

	@Value("${payment.serviceUrl}")
	private String paymentServiceUrl;

	@GetMapping("/consume/payment/get/{id}")
	public String paymentInfo(@PathVariable("id") Long id) {

		return restTemplate.getForObject(paymentServiceUrl + "/payment/get/" + id, String.class);
	}
}
