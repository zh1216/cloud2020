package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/4/5
 */
@Component
public class MyLb implements LoadBalance {

	private AtomicInteger atomicInteger = new AtomicInteger(0);

	/**
	 * 获取下标，且加一
	 * @return
	 */
	public final int getAndIncrement() {
		int current, next;
		do {
			current = this.atomicInteger.get();
			next = current >= Integer.MAX_VALUE ? 0 : current + 1;
		} while (!atomicInteger.compareAndSet(current, next));
		System.out.println("第几次访问***" + next);
		return next;
	}

	@Override
	public ServiceInstance instance(List<ServiceInstance> instances) {
		// 根据请求次数，取下标
		int index = getAndIncrement() % instances.size();
		return instances.get(index);
	}
}
