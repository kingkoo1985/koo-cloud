package com.koo.cloud.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;



public interface DefaultProcessChannel {
	public static final String OUTPUT = "cloud_output"; // 输出通道名称
	public static final String INPUT = "cloud_input"; // 输入通道名称
	
	@Input(DefaultProcessChannel.INPUT)
	public SubscribableChannel input();
	@Output(DefaultProcessChannel.OUTPUT)
	public MessageChannel output();
	
}
