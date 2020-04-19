package com.atguigu.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/4/20
 */
@Component
@Slf4j
public class CustomerFilter implements GlobalFilter, Ordered {
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		log.info("****************come in customerFilter ****{}",new Date());
		String uname = exchange.getRequest().getQueryParams().getFirst("uname");
		if(null == uname){
		   log.info("**********用户名为null,非法用户，o(╥﹏╥)o");
		   exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
		   return exchange.getResponse().setComplete();
		}
		return chain.filter(exchange);
	}

	/**
	 * 值越小，加载越靠前
	 * @return
	 */
	@Override
	public int getOrder() {
		return 0;
	}
}
