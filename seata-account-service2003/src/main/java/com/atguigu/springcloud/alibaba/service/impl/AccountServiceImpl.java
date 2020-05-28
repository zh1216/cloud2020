package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.AccountDao;
import com.atguigu.springcloud.alibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/5/19
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

	@Resource
	private AccountDao accountDao;

	@Override
	public void decrease(Long userId, BigDecimal money) {
		// 模拟超时
		//try { TimeUnit.SECONDS.sleep(20);} catch (InterruptedException e) {e.printStackTrace();}
		accountDao.decrease(userId,money);
		log.info("account service 扣减余额结束");//断点
	}
}

