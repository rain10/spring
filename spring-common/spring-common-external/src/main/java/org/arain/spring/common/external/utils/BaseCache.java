package org.arain.spring.common.external.utils;

import org.apache.commons.lang3.StringUtils;
import org.arain.spring.common.inside.base.exception.RunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Arain
 * @date 2018年10月26日 下午12:07:01
 */
@Component
@RefreshScope
public class BaseCache {
	
	@Value("${cache.isRedis}")
	private boolean flag;
	
	@Autowired
	private RedisUtils redisUtils;
	
	@Autowired
	private EhcacheUtil ehcacheUtil;
	
	@Value("${cache.ehcache.name}")
	private String cacheName;
	
	public void set(String key,Object value,int time) {
		if(flag) {
			redisUtils.set(key, value,time);
		} else {
			if(StringUtils.isBlank(cacheName)) {
				throw new RunException("ehcacheName为空");
			}
			ehcacheUtil.put(cacheName, key, value);
		}
	}
	
	
	public Object get(String key) {
		if(flag) {
			Object object = redisUtils.get(key);
			return object;
		} else {
			if(StringUtils.isBlank(cacheName)) {
				throw new RunException("ehcacheName为空");
			}
			Object object = ehcacheUtil.get(cacheName, key);
			return object;
		}
	}

	public void del(String key) {
		if(flag) {
			redisUtils.del(key);
		} else {
			if(StringUtils.isBlank(cacheName)) {
				throw new RunException("ehcacheName为空");
			}
			ehcacheUtil.remove(cacheName, key);
		}
	}
}
