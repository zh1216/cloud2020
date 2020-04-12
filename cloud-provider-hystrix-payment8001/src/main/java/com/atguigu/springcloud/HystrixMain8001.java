package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/4/7
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class HystrixMain8001 {
	public static void main(String[] args) {
		SpringApplication.run(HystrixMain8001.class, args);
	}
}
