package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 *@project:
 *@description: 处理服务提供测的运行异常时、超时、宕机备用方案
 *@author:zhangwenqiang
 *@date: 2020/4/12
 */
@Component
public class PaymentHystrixServiceFallBack implements PaymentHystrixService {


	@Override
	public String paymentInfo_OK(Integer id) {
		return "-----PaymentHystrixServiceFallBack---paymentInfo_OK";
	}

	@Override
	public String paymentInfo_TimeOut(Integer id) {
		return "-----PaymentHystrixServiceFallBack---paymentInfo_TimeOut";
	}
}
