package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/3/27
 */
@Configuration
public class ApplicationContextConfig {

	// 此处必须加@LoadBalanced注解，否则会报错
	@Bean
//	@LoadBalanced    //暂时注释，验证自定义规则
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
