package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/4/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMessage implements Serializable {

	private Integer id;
	private String body;
}
