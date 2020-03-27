package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/3/27
 */
@RestController
@Slf4j
public class PaymentController {

	@Resource
	private PaymentService paymentService;

	@PostMapping("/payment/create")
	public CommonResult create(@RequestBody Payment payment) {
		int result = paymentService.create(payment);
		log.info("插入数据结果{}", result);
		if (result > 0) {
			return new CommonResult(200, "成功", result);
		} else {
			return new CommonResult(444, "失败", null);
		}
	}

	@GetMapping("/payment/get/{id}")
	public CommonResult create(@PathVariable("id") Long id) {
		Payment result = paymentService.getPaymentById(id);
		log.info("查询数据结果{}", result);
		if (result != null) {
			return new CommonResult(200, "成功", result);
		} else {
			return new CommonResult(444, "失败", null);
		}
	}
}
