package com.koo.cloud.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfig {
	@Bean
	public AuthorizedRequestFilter getAuthoizedZuulPreRequestFilter() {
		return new AuthorizedRequestFilter();
	}
}
