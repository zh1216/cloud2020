package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.handler.CustomerHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/5/14
 */
@RestController
@Slf4j
public class RateLimitController {

	@GetMapping("/byResource")
	@SentinelResource(value = "byResource", blockHandler = "byResourceBlockExceptionHandler")
	public CommonResult byResource() {
		return new CommonResult(200, "资源名称限流",
				new Payment(200L, "serial0001"));
	}

	public CommonResult byResourceBlockExceptionHandler(BlockException exception) {
		return new CommonResult(444, exception.getClass().getCanonicalName(), null);
	}

	@GetMapping("/rateLimit/customerHandler")
	@SentinelResource(value = "customerHandler",
			blockHandlerClass = CustomerHandler.class,
	blockHandler = "blockExceptionHandler")
	public CommonResult byUrl(){
		return new CommonResult(200,"by url method ");
	}
}
