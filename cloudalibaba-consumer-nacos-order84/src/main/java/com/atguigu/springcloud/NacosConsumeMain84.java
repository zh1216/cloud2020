package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/5/15
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class NacosConsumeMain84 {
	public static void main(String[] args) {
		SpringApplication.run(NacosConsumeMain84.class,args);

	}
}
