package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/3/30
 */
@SpringBootApplication
@EnableDiscoveryClient // 用于向Consul或者Zookeeper作为注册中心时使用
public class PaymentMain8004 {
	public static void main(String[] args) {
		SpringApplication.run(PaymentMain8004.class, args);
	}
}
