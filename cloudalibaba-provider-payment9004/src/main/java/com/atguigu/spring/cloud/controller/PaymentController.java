package com.atguigu.spring.cloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/5/15
 */
@RestController
@Slf4j
public class PaymentController {

	@Value("${server.port}")
	private String port;

	private static Map<Long, Payment> paramMap = new HashMap<>();

	static {
		paramMap.put(1L, new Payment(1L, "111111111"));
		paramMap.put(2L, new Payment(2L, "222222222"));
		paramMap.put(3L, new Payment(3L, "333333333"));
	}

	@GetMapping("/paymentSQL/{id}")
	public CommonResult<Payment> paymentSql(@PathVariable("id") Long id) {
		Payment payment = paramMap.get(id);
		CommonResult<Payment> result = new CommonResult<>(200, "from server port:" + port, payment);
		return result;
	}

}
