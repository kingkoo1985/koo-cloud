package com.koo.cloud.provider.fallback;

import com.koo.cloud.provider.service.IUserClientService;

import feign.hystrix.FallbackFactory;

public class IUserClientServiceFallbackFactory implements FallbackFactory<IUserClientService> {

	@Override
	public IUserClientService create(Throwable arg0) {
		
		return new IUserClientService() {
			@Override
			public String home() {
				return "fallback";
			}			
		};
	}

}
