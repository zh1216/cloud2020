package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/4/19
 */
@Configuration
public class GateWayConfig {

	@Bean
	public RouteLocator customerRouteLocator(RouteLocatorBuilder builder){
		/**
		 * 	代码方式配置一个routes
		 * 	id: path_route_atguigu1
		 * 	断言：请求包含/guoji
		 * 	目标地址：http://news.baidu.com/guoji
		 */
		RouteLocatorBuilder.Builder routes = builder.routes();
		routes.route("path_route_atguigu1",
				t -> t.path("/guoji").uri("http://news.baidu.com")).build();
		return routes.build();
	}
}
