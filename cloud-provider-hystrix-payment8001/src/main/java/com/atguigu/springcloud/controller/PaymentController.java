package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.ReusableMessage;
import org.bouncycastle.pqc.math.linearalgebra.IntegerFunctions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/4/7
 */
@RestController
@Slf4j
public class PaymentController {

	@Value("${server.port}")
	private String port;

	@Resource
	PaymentService paymentService;

	@GetMapping("/payment/hystrix/ok/{id}")
	public String paymentInfo_OK(@PathVariable("id") Integer id) {
		String result = paymentService.paymentInfo_OK(id);
		log.info("*********result : " + result);
		return result;
	}

	/**
	 * 并发压测这个接口，上边OK的接口反应也会慢，因为tomcat默认工作线程被打满，没有
	 * 多余的线程来分解压力和处理。
	 * @param id
	 * @return
	 */
	@GetMapping("/payment/hystrix/timeout/{id}")
	public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
		String result = paymentService.paymentInfo_TimeOut(id);
		log.info("********result :" + result);
		return result;
	}
}
