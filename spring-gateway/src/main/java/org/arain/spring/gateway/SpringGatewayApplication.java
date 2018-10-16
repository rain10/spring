package org.arain.spring.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@ComponentScan(basePackages = { "org.arain.spring" })
@SpringCloudApplication
@EnableDiscoveryClient
public class SpringGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGatewayApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
