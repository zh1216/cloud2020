package com.atguigu.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/5/19
 */
@Mapper
public interface StorageDao {
	void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
