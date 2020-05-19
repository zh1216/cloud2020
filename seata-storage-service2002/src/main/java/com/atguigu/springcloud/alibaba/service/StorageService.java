package com.atguigu.springcloud.alibaba.service;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/5/19
 */
public interface StorageService {

	void decrease(Long productId, Integer count);
}
