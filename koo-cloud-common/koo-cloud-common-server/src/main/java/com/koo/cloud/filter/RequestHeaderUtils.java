package com.koo.cloud.filter;

import java.nio.charset.Charset;
import java.util.Base64;


public class RequestHeaderUtils {
	public static String getHeader(String userName, String password) {
		String auth = userName + ":" + password; // 认证的原始信息
		byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII"))); // 进行一个加密的处理
		// 在进行授权的头信息内容配置的时候加密的信息一定要与“Basic”之间有一个空格
		return "Basic " + new String(encodedAuth);
	}
}
