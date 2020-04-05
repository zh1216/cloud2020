package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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
	public CommonResult<Payment> create(Payment payment) {
		return restTemplate.postForObject(BASE_URL + "/payment/create", payment, CommonResult.class);
	}

	@GetMapping("/consume/payment/get/{id}")
	public CommonResult<Payment> getPayment(@PathVariable("id") long id) {
		// getForObject() 返回对象为响应体中数据转换成的对象，基本理解为Json
		return restTemplate.getForObject(BASE_URL + "/payment/get/" + id, CommonResult.class);
	}

	@GetMapping("/consume/payment/getEntity/{id}")
	public CommonResult<Payment> getPayment2(@PathVariable("id") long id) {
		// getForEntity() 返回对象为ResponseEntity,包含了响应中的重要信息，比如响应头，响应状态码，响应体等。
		ResponseEntity<CommonResult> respEntity = restTemplate.getForEntity(BASE_URL + "/payment/get/" + id, CommonResult.class);
		if (respEntity.getStatusCode().is2xxSuccessful()) {
			return respEntity.getBody();
		} else {
			return new CommonResult(444, "操作失败");
		}
	}
}
