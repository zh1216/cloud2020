package com.atguigu.springcloud.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/4/12
 */
@Component
public class PaymentHystrixServiceFallbackFactory implements FallbackFactory<PaymentHystrixService> {
	@Override
	public PaymentHystrixService create(Throwable throwable) {
		return new PaymentHystrixService() {
			@Override
			public String paymentInfo_OK(Integer id) {
				return "PaymentHystrixServiceFallbackFactory----paymentInfo_OK";
			}

			@Override
			public String paymentInfo_TimeOut(Integer id) {
				return "PaymentHystrixServiceFallbackFactory----paymentInfo_TimeOut";
			}
		};
	}
}
