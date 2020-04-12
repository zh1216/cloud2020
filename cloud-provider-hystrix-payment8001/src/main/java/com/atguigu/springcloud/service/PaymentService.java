package com.atguigu.springcloud.service;

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
	@HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
	})
	public String paymentInfo_TimeOut(Integer id) {
		int i = 10/0;
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
}
