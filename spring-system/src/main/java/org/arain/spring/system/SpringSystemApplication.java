package org.arain.spring.system;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * 
 * @author arain
 * @date 2018年10月25日 下午3:33:00
 */
@SpringCloudApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
public class SpringSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSystemApplication.class, args);
	}
}
