package com.koo.cloud.provider.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koo.cloud.provider.fallback.IUserClientServiceFallbackFactory;

@FeignClient(value = "KOO-CLOUD-SERVER-GATEWAY", fallbackFactory = IUserClientServiceFallbackFactory.class)
public interface IUserClientService {
	
	@RequestMapping(method = RequestMethod.GET, value = "/user-proxy/home/")
	public String home();
}