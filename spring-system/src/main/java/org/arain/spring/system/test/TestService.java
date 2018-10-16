package org.arain.spring.system.test;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="auth-server",fallback=TestServiceImpl.class)
public interface TestService {
	
	@RequestMapping("bbc")
	public String bbb();
}
