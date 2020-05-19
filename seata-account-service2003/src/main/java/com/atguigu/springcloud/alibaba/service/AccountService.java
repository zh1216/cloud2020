package com.atguigu.springcloud.alibaba.service;

import java.math.BigDecimal;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/5/19
 */
public interface AccountService {
	void decrease(Long userId, BigDecimal money);
}
