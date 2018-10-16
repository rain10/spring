package org.arain.spring.system.test;

import org.springframework.stereotype.Component;

@Component
public class TestServiceImpl implements TestService{

	@Override
	public String bbb() {
		System.out.println("--------------------------------------");
		return "yyyyyy";
	}

}
