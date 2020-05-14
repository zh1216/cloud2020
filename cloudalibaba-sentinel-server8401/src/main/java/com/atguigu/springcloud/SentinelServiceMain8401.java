package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/5/10
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelServiceMain8401 {
	public static void main(String[] args) {
		SpringApplication.run(SentinelServiceMain8401.class,args);
	}
}
