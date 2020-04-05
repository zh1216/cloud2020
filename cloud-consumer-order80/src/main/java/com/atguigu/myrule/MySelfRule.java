package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@project:
 *@description: 不能放到@ComponentScan注解扫描到的包以及子包下，
 * 否则这个自定义配置类会被所有的Ribbon客户端共享，达不到特殊化定制目的
 *@author:zhangwenqiang
 *@date: 2020/4/4
 */
@Configuration
public class MySelfRule {

	@Bean
	public IRule myRule(){
		// 使用随机访问规则
		return new RandomRule();
	}
}
