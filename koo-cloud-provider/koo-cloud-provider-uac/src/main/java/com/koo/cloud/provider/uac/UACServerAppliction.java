package com.koo.cloud.provider.uac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;


@EnableEurekaClient
@SpringBootApplication
@EnableCircuitBreaker//启用断路器
@ComponentScan("com.koo.cloud.rest,com.koo.cloud.channel")
public class UACServerAppliction 
{	
    public static void main( String[] args )
    {
    	SpringApplication.run(UACServerAppliction.class, args);
    }
}
