package com.koo.cloud.channel.message;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import com.koo.cloud.channel.DefaultProcessChannel;
import com.koo.cloud.channel.IMessageProvider;
import com.koo.cloud.channel.MessageVo;

@Component
@EnableBinding(DefaultProcessChannel.class) // 可以理解为是一个消息的发送管道的定义
public class MessageProviderImpl implements IMessageProvider {
	@Qualifier(DefaultProcessChannel.OUTPUT) // 由于类型重复，所以设置一个标记
	@Resource
	private MessageChannel output; // 消息的发送管道

	@Override
	public void send(MessageVo message) {
		// 创建并发送消息
		this.output.send(MessageBuilder.withPayload(message).build());
	}
}
