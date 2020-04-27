package com.atguigu.springcloud.didi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
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

	@StreamListener(TestTopic.INPUT)
	public void receive(Message message){
		log.info("接收到消息{}",message.getPayload().toString());
	}
}
