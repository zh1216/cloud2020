package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/3/27
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentMain8001 {
	public static void main(String[] args) {
		SpringApplication.run(PaymentMain8001.class, args);
	}
}
