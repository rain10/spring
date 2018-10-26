package org.arain.spring.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
/**
 * 
 * @author arain
 * @date 2018年10月25日 下午1:25:23
 */
@SpringCloudApplication
@ComponentScan(basePackages = {"org.arain.spring.common.inside","org.arain.spring.auth","org.arain.spring.common.external"})
@EnableDiscoveryClient
@MapperScan("org.arain.spring.common.inside.base.auth.mapper")
@PropertySource(value={"classpath:auth.properties"})
public class SpringAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAuthApplication.class, args);
	}
}
