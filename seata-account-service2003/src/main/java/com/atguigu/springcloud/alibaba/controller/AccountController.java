package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import com.atguigu.springcloud.alibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/5/19
 */
@RestController
@Slf4j
public class AccountController {

	@Resource
	private AccountService accountService;

	@RequestMapping("/account/decrease")
	public CommonResult decrease(Long userId, BigDecimal money){
		accountService.decrease(userId,money);
		return new CommonResult(200,"扣费成功");
	}
}
