package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/3/30
 */
@RestController
@Slf4j
public class PaymentController {

	@Value("${server.port}")
	private String port;

	@RequestMapping("/payment/zk")
	public String paymentZk() {
		return "SpringCloud with zookeeper\t" + port + "\t" + UUID.randomUUID().toString();
	}
}
