package org.arain.spring.config.config;

import org.arain.spring.config.filter.BusRefreshFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Arain
 * @date 2018年10月25日 上午11:29:57
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean filterRegistrationBeanBusRefresh() {
		FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
		filterRegistration.setFilter(new BusRefreshFilter());
		filterRegistration.addUrlPatterns("/*");
		return filterRegistration;
	}
	
}
