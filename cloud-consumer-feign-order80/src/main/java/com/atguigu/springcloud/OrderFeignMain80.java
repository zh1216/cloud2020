package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/4/5
 */
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class OrderFeignMain80 {
	public static void main(String[] args) {
		SpringApplication.run(OrderFeignMain80.class, args);
	}
}
