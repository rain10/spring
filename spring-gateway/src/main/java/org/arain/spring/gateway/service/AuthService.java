package org.arain.spring.gateway.service;

import java.util.List;
import java.util.Map;

import org.arain.spring.gateway.service.impl.AuthServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Arain
 * @date 2018年10月19日 上午11:14:52
 */
@FeignClient(value="auth-server",fallback=AuthServiceImpl.class)
public interface AuthService {
	/**
	 * 
	 * @param token
	 * @return
	 */
	@RequestMapping("/auth/loadJWTInfo")
	@ResponseBody
	public Map<String, Object> loadJWTInfo(@RequestParam("token") String token);
	
	/**
	 * 
	 * @param serialNo
	 * @return
	 */
	@RequestMapping(value="/auth/loadPermissions/{serialNo}")
	@ResponseBody
	public List<Map<String, Object>> getPermissionByUserSerialNo(@PathVariable("serialNo") String serialNo);
	  
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/auth/loadAllPermissions")
	@ResponseBody
	List<Map<String, Object>> getAllPermissionInfo();
}
