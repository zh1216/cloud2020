package com.atguigu.springcloud.didi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/4/27
 */
@Component
@Slf4j
public class TestListener {

	int counter = 1;

	@StreamListener(TestTopic.INPUT)
	public void receive(Message message) {
		log.info("接收到消息{}", message.getPayload().toString());
		if (counter == 3) {
			counter = 1;
			// 抛出此异常，直接进入死信队列
			throw new AmqpRejectAndDontRequeueException("tried 3 times failed，send to dlq！");
		} else {
			counter++;
			// 模拟消息消费失败
			throw new RuntimeException("Message consumer failed!");
		}
	}

//	/**
//	 * 	消息消费方法失败，调用这个方法
//	 * 	aaa-topic : 对应输入通道的destination(目标)
//	 * 	stream-exception-handler: 对应输入通道组名
//	 * @param message
//	 */
//	@ServiceActivator(inputChannel="aaa-topic.stream-exception-handler.errors")
//	public void errorMethod(Message message){
//		log.info("message consume failed , call back ！");
//	}
}
