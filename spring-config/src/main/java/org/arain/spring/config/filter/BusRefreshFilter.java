package org.arain.spring.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Arain
 * @date 2018年10月25日 上午11:20:50
 */
@Configuration
public class BusRefreshFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;

        String url = new String(httpServletRequest.getRequestURI());
        if (!url.endsWith("/bus-refresh")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        CustometRequestWrapper requestWrapper = new CustometRequestWrapper(httpServletRequest);
        filterChain.doFilter(requestWrapper, servletResponse);
	}

	@Override
	public void destroy() {
		
	}

}
