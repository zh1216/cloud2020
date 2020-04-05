package com.atguigu.springcloud.feign;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/4/5
 */
@FeignClient("CLOUD-PAYMENT-SERVICE")
@Component
public interface PaymentFeignClient {

	@GetMapping("/payment/get/{id}")
	CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

	@GetMapping("/payment/timeout")
	String paymentTimeout();
}
