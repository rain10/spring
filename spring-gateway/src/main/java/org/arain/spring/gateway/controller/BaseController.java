package org.arain.spring.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
	
	@RequestMapping("fallbackcontroller")
	public String fallbackcontroller() {
		return "fallbackcontroller";
	}
}
