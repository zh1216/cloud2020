package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.feign.PaymentFeign;
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
 *@date: 2020/5/15
 */
@RestController
@Slf4j
public class CircleBreakController {

	@Value("${service.url}")
	private String SERVICE_URL;

	@Resource
	private RestTemplate restTemplate;

	@Resource
	PaymentFeign paymentFeign;


	@GetMapping("/consume/fallback/{id}")
//	@SentinelResource(value = "fallback") // 报错直接error界面
//	@SentinelResource(value = "fallback",fallback = "fallbackMethod") // 只负责java异常
//	@SentinelResource(value = "fallback",blockHandler = "blockHandler") // 只负责Sentinel配置异常
//	@SentinelResource(value = "fallback", blockHandler = "blockHandler", fallback = "fallbackMethod") // 同时配置，两者都能进行兜底
	@SentinelResource(value = "fallback", blockHandler = "blockHandler", fallback = "fallbackMethod",
			exceptionsToIgnore = {IllegalArgumentException.class})
	public CommonResult<Payment> consumePayment(@PathVariable("id") long id) {
		CommonResult result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);
		if (4 == id) {
			throw new IllegalArgumentException("非法参数。。。");
		} else if (result.getData() == null) {
			throw new NullPointerException("空指针异常");
		}
		return result;
	}

	// fallback处理，可以多一个Throwable类型参数
	public CommonResult<Payment> fallbackMethod(@PathVariable("id") long id, Throwable e) {
		return new CommonResult<>(444, "fallbackMethod");
	}

	// blockHandler配置异常处理，必须多一个BlockException类型参数
	public CommonResult<Payment> blockHandler(@PathVariable("id") long id, BlockException blockException) {
		return new CommonResult<>(445, "blockException Method ");
	}

	@GetMapping("/consume/feign/{id}")
	public CommonResult<Payment> consumePayment(@PathVariable("id") Long id){
		return paymentFeign.paymentSql(id);
	}
}
