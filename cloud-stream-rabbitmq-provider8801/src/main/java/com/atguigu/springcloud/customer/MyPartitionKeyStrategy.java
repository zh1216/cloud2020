package com.atguigu.springcloud.customer;

import org.springframework.cloud.stream.binder.PartitionKeyExtractorStrategy;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/4/27
 */
@Component
public class MyPartitionKeyStrategy implements PartitionKeyExtractorStrategy {

	@Override
	public Object extractKey(Message<?> message) {
		// 消息对象
		Object payload = message.getPayload();
		int result = 0;
		if (payload instanceof String) {
			String msg = (String) payload;
			// 截取第一位(0或者1),返回对应分区下标
			result = Integer.parseInt(msg.substring(0, 1));

		}
		return result;
	}
}
