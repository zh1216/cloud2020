package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/4/23
 */
@RestController
@RefreshScope
public class ConfigClientController {

	@Value("${config.info}")
	private String configInfo;

	@Value("${server.port}")
	private String port;

	@GetMapping("/configInfo")
	public String getConfigInfo(){
		return "server post " + port +  configInfo;
	}
}
