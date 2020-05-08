package com.atguigu.spirngcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/5/8
 */
@RestController
@Slf4j
public class PaymentController {

	@Value("${server.port}")
	private String port;

	@GetMapping("/payment/get/{id}")
	public String getPayment(@PathVariable("id") Long id){
		return "nacos registry server port " + port + "\t id : "+ id;
	}
}
