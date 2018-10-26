package org.arain.spring.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
/**
 * 
 * @author arain
 * @date 2018年10月26日 上午8:02:46
 */
@SpringCloudApplication
@EnableAdminServer
public class SpringMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMonitorApplication.class, args);
	}
}
