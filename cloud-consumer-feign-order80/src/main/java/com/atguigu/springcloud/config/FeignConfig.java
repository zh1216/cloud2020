package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/4/5
 */
@Configuration
public class FeignConfig {

	@Bean
	public Logger.Level feignLoggerLevel(){
		// 请求和响应的头信息，请求和响应的正文和元数据
		return Logger.Level.FULL;
	}
}
