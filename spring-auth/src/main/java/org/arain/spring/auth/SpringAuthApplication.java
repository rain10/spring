package org.arain.spring.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringCloudApplication
@EnableDiscoveryClient
public class SpringAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAuthApplication.class, args);
	}
}
