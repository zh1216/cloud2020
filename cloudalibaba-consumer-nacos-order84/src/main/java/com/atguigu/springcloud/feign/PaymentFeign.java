package com.atguigu.springcloud.feign;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/5/15
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFeignFallBack.class)
public interface PaymentFeign {

	@GetMapping("/paymentSQL/{id}")
	public CommonResult<Payment> paymentSql(@PathVariable("id") Long id);
}
