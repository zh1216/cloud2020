package com.atguigu.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/5/19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	private Long id;
	private Integer userId;
	private BigDecimal total;
	/**
	 * '已用余额'
	 */
	private BigDecimal used;
	/**
	 * 剩余可用额度
	 */
	private BigDecimal residue;

}
