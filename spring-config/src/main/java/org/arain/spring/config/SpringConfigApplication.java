package org.arain.spring.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
/**
 * 
 * @author arain
 * @date 2018年10月29日 上午8:39:42
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class SpringConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigApplication.class, args);
	}
}
