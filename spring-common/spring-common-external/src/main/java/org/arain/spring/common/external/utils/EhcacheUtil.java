package org.arain.spring.common.external.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Component;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

/**
 *
 * @author Arain
 * @date 2018年10月26日 上午11:38:40
 */

@Component
public class EhcacheUtil {
	
	@Autowired
	EhCacheCacheManager appEhCacheCacheManager;
	/**
	 * 设置缓存
	 * 
	 * @author ..
	 * @date 2018年10月11日 下午3:06:41
	 */
	public void put(String cacheName, String key, Object value) {
		Cache cache = appEhCacheCacheManager.getCacheManager().getCache(cacheName);
		Element element = new Element(key, value);
		cache.put(element);
		System.out.println(cache);
	}
	
	/**
	 * 获取缓存
	 * 
	 * @author  ..
	 * @date 2018年10月11日 下午3:06:53
	 */
	public Object get(String cacheName, String key) {
		Cache cache = appEhCacheCacheManager.getCacheManager().getCache(cacheName);
		Element element = cache.get(key);
		return element == null ? null : element.getObjectValue();
	}
	
	/**
	 * 获取ehcache
	 * 
	 * @author ..
	 * @date 2018年10月11日 下午3:07:14
	 */
	public Cache get(String cacheName) {
		return appEhCacheCacheManager.getCacheManager().getCache(cacheName);
	}
	
	/**
	 * 删除缓存
	 * 
	 * @author ..
	 * @date 2018年10月11日 下午3:07:37
	 */
	public void remove(String cacheName, String key) {
		Cache cache = appEhCacheCacheManager.getCacheManager().getCache(cacheName);
		cache.remove(key);
	}

}
