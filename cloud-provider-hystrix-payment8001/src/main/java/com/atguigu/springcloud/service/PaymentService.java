package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/4/7
 */
@Service
public class PaymentService {

	public String paymentInfo_OK(Integer id) {
		return "线程池" + Thread.currentThread().getName() + "payment_ok \t id:" + id;
	}

	// 指定降级方法，指定方法处理超过3秒走降级方法
	@HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
	})
	public String paymentInfo_TimeOut(Integer id) {
		int i = 10 / 0;
//		try {
//			TimeUnit.SECONDS.sleep(5);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		return "线程池" + Thread.currentThread().getName() + "payment_timeout \t id:" + id;
	}

	/**
	 * 	降级方法
	 * @param id
	 * @return
	 */
	public String paymentInfo_TimeOutHandler(Integer id) {

		return "线程池" + Thread.currentThread().getName() + "payment_timeoutHandler o(╥﹏╥)o";
	}


	//-=============【服务熔断】=======================


	@HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
		@HystrixProperty(name="circuitBreaker.enabled",value = "true"),// 是否开启断路器, 默认true
		@HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"), // 使熔断打开的最小请求数量 默认20,即在时间窗口，仅收到19个请求，19个都失败熔断器也不会打开
		@HystrixProperty(name ="circuitBreaker.sleepWindowInMilliseconds",value = "20000"),// 跳闸后，拒绝请求的窗口期。默认5000毫秒
		@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")// 失败率百分比 默认50%
			})
	public String paymentCircuitBreaker(Integer id) {
		if (id < 0) {
			throw new RuntimeException("id 不能为负数");
		}
		String serial = IdUtil.simpleUUID();
		return Thread.currentThread().getName() + "\t" + "调用成功，流水号" + serial;
	}

	public String paymentCircuitBreakerFallback(Integer id) {
		return "id 不能为负数，请稍后再试 o(╯□╰)o";
	}
}
