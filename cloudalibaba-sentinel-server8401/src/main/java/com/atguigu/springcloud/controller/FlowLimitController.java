package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/5/10
 */
@RestController
@Slf4j
public class FlowLimitController {

	@GetMapping("/testA")
	public String testA() {
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} //验证线程数阈值
		log.info(Thread.currentThread().getName());
		return "testA";
	}

	@GetMapping("/testB")
	public String testB() {
		return "testB";
	}

	/**
	 * 测试降级
	 * @return
	 */
	@GetMapping("/testD")
	public String testD() {
		// 测试RT
//		try { TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}

		// 测试异常比例
		int age = 10 / 0;
		return "testD";
	}

	/**
	 * SentinelResource注解中blockHandler选项只针对sentinel配置的规则超过阈值的异常
	 * @return
	 */
	@RequestMapping("/testHotKey")
	@SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
	public String testHotKey(@RequestParam(name = "p1", required = false) String p1,
							 @RequestParam(name = "p2", required = false) String p2) {
		return "test hot key";
	}

	/**
	 * 参数类型需要和原方法相匹配并且最后加一个额外的参数，类型为 BlockException。blockHandler 函数默认需要和原方法在同一个类中。
	 * 若希望使用其他类的函数，则可以指定 blockHandlerClass 为对应的类的 Class 对象，注意对应的函数必需为 static 函数，否则无法解析
	 * @return
	 */
	public String deal_testHotKey(String p1, String p2, BlockException blockException) {
		return "test hot key o(╥﹏╥)o";
	}
}
