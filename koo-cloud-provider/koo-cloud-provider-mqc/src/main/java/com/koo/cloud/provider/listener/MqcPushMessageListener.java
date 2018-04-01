package com.koo.cloud.provider.listener;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.koo.cloud.channel.MqMessage;
import com.koo.cloud.util.PublicUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MqcPushMessageListener implements MessageListenerConcurrently {
	
	@Resource
	private StringRedisTemplate srt;
	
	@Override
	//@MqConsumerStore
	public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
		MessageExt msg = msgs.get(0);
		String body = new String(msg.getBody());
		String topicName = msg.getTopic();
		String tags = msg.getTags();
		String keys = msg.getKeys();
		log.info("MQ消费Topic={},tag={},key={},body={}", topicName, tags, keys, body);
		ValueOperations<String, String> ops = srt.opsForValue();
		// 控制幂等性使用的key
		try {
			MqMessage.checkMessage(body, topicName, tags, keys);
			String mqKV = null;
			if (srt.hasKey(keys)) {
				mqKV = ops.get(keys);
			}
			if (PublicUtils.isNotEmpty(mqKV)) {
				log.error("MQ消费Topic={},tag={},key={}, 重复消费", topicName, tags, keys);
				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			}
			//处理逻辑
			
		} catch (IllegalArgumentException ex) {
			log.error("校验MQ message 失败 ex={}", ex.getMessage(), ex);
			return ConsumeConcurrentlyStatus.RECONSUME_LATER;
		} catch (Exception e) {
			log.error("处理MQ message 失败 topicName={}, keys={}, ex={}", topicName, keys, e.getMessage(), e);
			return ConsumeConcurrentlyStatus.RECONSUME_LATER;
		}
		ops.set(keys, keys, 10, TimeUnit.DAYS);
		return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
	}

}
