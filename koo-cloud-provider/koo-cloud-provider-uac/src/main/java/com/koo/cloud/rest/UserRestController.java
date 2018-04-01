package com.koo.cloud.rest;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koo.cloud.channel.IMessageProvider;
import com.koo.cloud.channel.MessageVo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class UserRestController {
	
	@Resource
	private IMessageProvider sender ;	// 消息的发送管道
	
	@RequestMapping("/home")
	@HystrixCommand
	public String home() throws InterruptedException  {		
		return "Hello world" + new Date().getTime();
	}
	
	
	
	@RequestMapping("/message")
	@HystrixCommand
	public String message() {
		MessageVo message = new MessageVo();
		message.setBody("1111");
		message.setTitle("title");
		this.sender.send(message);
		return "Hello world" + new Date().getTime();
	}
}
