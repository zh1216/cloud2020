package com.atguigu.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/5/15
 */
public class CustomerHandler {

	public static CommonResult blockExceptionHandler(BlockException exception) {
		return new CommonResult(2020, "自定义限流信息  CustomerHandler");
	}
}
