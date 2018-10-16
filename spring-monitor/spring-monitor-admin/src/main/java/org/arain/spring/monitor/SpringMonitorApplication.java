package org.arain.spring.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringCloudApplication
@EnableAdminServer
public class SpringMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMonitorApplication.class, args);
	}
}
