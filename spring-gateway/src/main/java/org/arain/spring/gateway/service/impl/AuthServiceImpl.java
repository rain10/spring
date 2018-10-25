package org.arain.spring.gateway.service.impl;

import java.util.List;
import java.util.Map;

import org.arain.spring.gateway.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author Arain
 * @date 2018年10月19日 上午11:15:15
 */
@Service
public class AuthServiceImpl implements AuthService{
	
	private static final Logger LOG = LoggerFactory.getLogger(AuthServiceImpl.class);
	
	@Override
	public Map<String, Object> loadJWTInfo(String token) {
		LOG.error("{}加载auth-server服务JTWInfo超时，请稍后重试",token);
		return null;
	}

	@Override
	public List<Map<String, Object>> getPermissionByUserSerialNo(String serialNo) {
		LOG.error("{}加载auth-server服务用户权限超时，请稍后重试",serialNo);
		return null;
	}

	@Override
	public List<Map<String, Object>> getAllPermissionInfo() {
		LOG.error("auth-server服务加载所有权限超时，请稍后重试");
		return null;
	}

}
