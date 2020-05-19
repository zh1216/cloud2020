package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.StorageDao;
import com.atguigu.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/5/19
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

	@Resource
	StorageDao storageDao;

	@Override
	public void decrease(Long productId, Integer count) {
		storageDao.decrease(productId,count);
	}
}
