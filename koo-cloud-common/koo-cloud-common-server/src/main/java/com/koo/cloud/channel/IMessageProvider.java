package com.koo.cloud.channel;
/**
 * 实现消息的发送，本次发送的消息是一个对象（自动变为json）
 * @param MessageVo VO对象，该对象不为null
 */
public interface IMessageProvider 
{
	
	public void send(MessageVo message) ;
}
