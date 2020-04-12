package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/4/12
 */
@SpringBootApplication
@EnableFeignClients
public class HystrixOrderMain80 {
	public static void main(String[] args) {
		SpringApplication.run(HystrixOrderMain80.class, args);
	}
}
