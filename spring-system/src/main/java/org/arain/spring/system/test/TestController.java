package org.arain.spring.system.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@GetMapping("aaa")
	public String aa() {
		System.out.println("aaaaa");
		return testService.bbb();
	}
}
