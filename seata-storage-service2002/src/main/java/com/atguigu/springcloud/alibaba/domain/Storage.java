package com.atguigu.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/5/19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
	private Long id;
	private Long productId;
	private Integer total;
	private Integer used;
	private Integer residue;

}
