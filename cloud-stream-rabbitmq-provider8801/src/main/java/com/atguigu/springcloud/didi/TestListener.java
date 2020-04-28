package com.atguigu.springcloud.didi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
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

//	int counter = 1;
//
//	@StreamListener(TestTopic.INPUT)
//	public void receive(Message message) {
//		log.info("接收到消息{}", message.getPayload().toString());
//		if (counter == 3) {
//			counter = 1;
//			// 抛出此异常，直接进入死信队列
//			throw new AmqpRejectAndDontRequeueException("tried 3 times failed，send to dlq！");
//		} else {
//			counter++;
//			// 模拟消息消费失败
//			throw new RuntimeException("Message consumer failed!");
//		}
//	}

	/**
	 * condition
	 * @param message
	 * @param version
	 */
	@StreamListener(value = TestTopic.INPUT,condition="headers['version']=='1.0'")
	public void receiveV1(Message message, @Header("version") String version) {
		log.info("receive v1 接收到消息{}\t，版本{}", message.getPayload().toString(), version);
	}


	@StreamListener(value = TestTopic.INPUT,condition="headers['version']=='2.0'")
	public void receiveV2(Message message, @Header("version") String version) {
		log.info("receive v2 接收到消息{}\t，版本{}", message.getPayload().toString(), version);
	}

	@StreamListener(value = TestTopic.INPUT)
	public void receiveDelay(Message message){
		log.info("receive delay method 接收到消息{}", message.getPayload().toString());
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
