package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/3/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {
	private Long id;
	private String serial;
}
