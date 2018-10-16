package org.arain.spring.eureka.config;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

/**
 *
 * @author Arain
 * @date 2018年10月9日 下午4:34:38
 */

@Configuration
public class FilterConfig {
		
	@Bean
	public Filter webRequestLoggingFilter() {
	    return new CommonsRequestLoggingFilter();
	}
}
