package com.atguigu.springcloud.feign;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/5/15
 */
@Component
public class PaymentFeignFallBack implements PaymentFeign{
	@Override
	public CommonResult<Payment> paymentSql(Long id) {
		return new CommonResult<>(555,"feign 降级返回");
	}
}
