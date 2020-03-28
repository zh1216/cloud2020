package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/3/27
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderMain80 {
	public static void main(String[] args) {
		SpringApplication.run(OrderMain80.class, args);
	}
}
