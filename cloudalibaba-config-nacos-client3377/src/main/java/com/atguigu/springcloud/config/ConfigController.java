package com.atguigu.springcloud.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/5/8
 */
@RestController
@Slf4j
@RefreshScope
public class ConfigController {

	@Value("${config.info}")
	private String configInfo;

	@GetMapping("/config/info")
	public String configInfo(){
		return configInfo;
	}
}
