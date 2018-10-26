package org.arain.spring.common.external.cache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * 
 * @author arain
 * @date 2018年10月26日 上午11:37:37
 */
@Configuration
@EnableCaching
public class CacheConfiguration {
	
	/**
	 * 根据shared与否的设置，spring分别通过CacheManager。create()或new CacheManager()方式来创建一个ehcache基地
	 * 
	 * @author ..
	 * @date 2018年10月11日 下午2:42:12
	 */
	@Bean
	public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
		EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
		cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));	
		cacheManagerFactoryBean.setShared(true);
		return cacheManagerFactoryBean;
	}
	
	/**
	 * 主要的管理器
	 * 
	 * @author ..
	 * @date 2018年10月11日 下午2:53:11
	 */
	@Bean(name="appEhCacheCacheManager")
	public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean bean) {
		return new EhCacheCacheManager(bean.getObject());
	}
	

}
