package com.koo.cloud.provider.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koo.cloud.provider.service.IUserClientService;

@RestController
public class UserController {
	
	@Resource
	private IUserClientService deptService ;
	
	@RequestMapping(value = "/consumer/home")
	public Object home() {
		return this.deptService.home();
	}
}
