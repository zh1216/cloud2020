package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entities.CustomerMessage;
import com.atguigu.springcloud.service.IMessageProvider;
import com.sun.xml.internal.ws.api.fastinfoset.FastInfosetFeature;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.Random;
import java.util.UUID;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/4/26
 */
@EnableBinding(Source.class)  // 定义消息推送通道
public class MessageProviderImpl implements IMessageProvider {

	@Resource
	private MessageChannel output;

	@Override
	public String send(Integer id) {
		if (id == 1) {
			String serial = UUID.randomUUID().toString();
			output.send(MessageBuilder.withPayload(serial).build());
			System.out.println("serial*******" + serial);
		}else {
//			CustomerMessage customerMessage = new CustomerMessage(999, "send message 999...");
//			output.send(MessageBuilder.withPayload(customerMessage).build());
//			System.out.println("customerMessage*******" + customerMessage);
			String serial = "abcdefghi";
			int i = new Random().nextInt(2);
			serial  = i + serial;
			output.send(MessageBuilder.withPayload(serial).build());
			System.out.println("serial*******" + serial);
		}

		return null;
	}
}
