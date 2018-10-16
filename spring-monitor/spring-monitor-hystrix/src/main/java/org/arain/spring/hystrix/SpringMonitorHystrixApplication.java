package org.arain.spring.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableHystrixDashboard
@EnableHystrix
@EnableTurbine
public class SpringMonitorHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMonitorHystrixApplication.class, args);
	}
}
