package com.atguigu.springcloud.didi;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/4/27
 */
public interface TestTopic {

	String OUTPUT= "example-topic-output";
	String INPUT= "example-topic-input";

	@Output(OUTPUT)
	MessageChannel output();

	@Input(INPUT)
	SubscribableChannel input();
}
