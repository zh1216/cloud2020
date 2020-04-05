package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/4/5
 */
public interface LoadBalance {
	/**
	 * 	根据规则，从所有服务列表筛选服务
	 * @param instances
	 * @return
	 */
	ServiceInstance instance(List<ServiceInstance> instances);
}
