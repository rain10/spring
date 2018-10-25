package org.arain.spring.auth.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author arain
 * @date 2018年10月24日 上午9:54:07
 */
@RestController
public class TestController {
	
	@Value("${server.port}")
    String port;
	
	@RequestMapping("bbc")
	public String port() {
		return port;
	}
}
