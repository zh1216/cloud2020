package com.atguigu.springcloud;

import com.atguigu.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/3/27
 */
@SpringBootApplication
@EnableEurekaClient
// 项目启动，根据服务提供方名称加载我们自定义的ribbon配置类，从而使配置生效
@RibbonClient(value = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class OrderMain80 {
	public static void main(String[] args) {
		SpringApplication.run(OrderMain80.class, args);
	}
}
