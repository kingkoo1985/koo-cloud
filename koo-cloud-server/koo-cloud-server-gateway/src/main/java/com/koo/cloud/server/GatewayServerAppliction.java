package com.koo.cloud.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableCircuitBreaker
public class GatewayServerAppliction {
	public static void main(String[] args) {
		SpringApplication.run(GatewayServerAppliction.class, args);
	}
}
