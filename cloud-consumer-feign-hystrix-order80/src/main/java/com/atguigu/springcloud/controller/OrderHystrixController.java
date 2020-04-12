package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/4/12
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

	@Autowired
	PaymentHystrixService paymentHystrixService;

	@GetMapping("/consume/payment/hystrix/ok/{id}")
	public String paymentInfo_OK(@PathVariable("id") Integer id) {
		return paymentHystrixService.paymentInfo_OK(id);
	}

	@GetMapping("/consume/payment/hystrix/timeout/{id}")
	public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
		return paymentHystrixService.paymentInfo_TimeOut(id);
	}

	/**
	 * 	全局fallback办法
	 * 	避免了一个方法对应一个降级，避免了代码膨胀，但是和业务耦合在一起
	 * @return
	 */
	public String payment_Global_FallbackMethod() {
		return "全局异常配置,请稍后再试";
	}
}
