package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.spec.ECFieldF2m;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *@project:
 *@description:
 *@author:zhangwenqiang
 *@date: 2020/3/27
 */
@RestController
@Slf4j
public class PaymentController {

	@Resource
	private PaymentService paymentService;

	@Value("${server.port}")
	private String port;

	@Resource
	DiscoveryClient discoveryClient;

	@PostMapping("/payment/create")
	public CommonResult create(@RequestBody Payment payment) {
		int result = paymentService.create(payment);
		log.info("插入数据结果{}", result);
		if (result > 0) {
			return new CommonResult(200, "成功", result);
		} else {
			return new CommonResult(444, "失败", null);
		}
	}

	@GetMapping("/payment/get/{id}")
	public CommonResult getPaymentById(@PathVariable("id") Long id) {
		Payment result = paymentService.getPaymentById(id);
		log.info("查询数据结果{}", result);
		if (result != null) {
			return new CommonResult(200, "成功{" + port + "}", result);
		} else {
			return new CommonResult(444, "失败", null);
		}
	}

	@GetMapping("/payment/timeout")
	public String paymentTimeout() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return port;
	}

	@GetMapping("/payment/discovery")
	public Object discovery() {
		// 获取所有注册进eureka的服务模块
		List<String> services = discoveryClient.getServices();
		for (String element : services) {
			log.info("element=========={}", element);
		}
		// 获取名为x的实例信息
		List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
		for (ServiceInstance instance : instances) {
			log.info(instance.getServiceId() + "\t\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
		}
		return this.discoveryClient;
	}

	@GetMapping("/payment/lb")
	public String getPaymentLb() {
		return port;
	}

	@GetMapping("/payment/zipkin")
	public String paymentZipKin(HttpServletRequest request){
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()){
			String header = headerNames.nextElement();
			log.info("header:{},info:{}",header,request.getHeader(header));
		}
		log.info("payment service receive request ...");
		return "hello sleuth + zipkin";
	}
}
