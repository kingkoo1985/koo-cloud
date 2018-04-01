package com.koo.cloud.provider.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.koo.cloud.channel.IMessageProvider;
import com.koo.cloud.channel.MessageVo;
import com.koo.cloud.provider.uac.UACServerAppliction;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=UACServerAppliction.class)
@WebAppConfiguration
public class TestMessageProvider {
	@Resource
	private IMessageProvider messageProvider ;
	
	
	@Test
	public void testSend() {
		MessageVo company = new MessageVo() ;
		company.setTitle("hello");
		company.setBody("更多资源请登录：www.mldn.cn");
		this.messageProvider.send(company);	// 消息发送
	}
}
