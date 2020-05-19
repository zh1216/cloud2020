package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import com.atguigu.springcloud.alibaba.domain.Order;
import com.atguigu.springcloud.alibaba.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/5/19
 */
@RestController
@Slf4j
public class OrderController {

	@Resource
	OrderService orderService;

	@GetMapping("/order/create")
	public CommonResult order(Order order){
		orderService.create(order);
		return new CommonResult(200,"订单创建成功");
	}
}
