package org.arain.spring.auth.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.arain.spring.auth.dto.SecurityDto;
import org.arain.spring.auth.service.SecurityService;
import org.arain.spring.common.inside.result.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author Arain
 * @date 2018年10月18日 上午11:18:44
 */
@RestController
@RequestMapping("auth")
public class SecurityController extends AuthController{
	
	@Autowired
	private SecurityService securityService;

	@Value("${token-header}")
	private String tokenHead;
	
	@PostMapping("login")
	public ResultMap login(final SecurityDto dto) {
		JSONObject token = securityService.login(dto);
		return success(token);
	}
	
	@PostMapping("logout")
	public ResultMap logout(final HttpServletRequest request) {
		String token = request.getHeader(tokenHead);
		securityService.logout(token);
		return success();
	}
	
	@PostMapping("loadUserInfo")
	public ResultMap userInfo(final HttpServletRequest request,final SecurityDto dto) {
		String token = request.getHeader(tokenHead);
		securityService.loadUserInfo(token,dto);
		return success(dto);
	}
	
	@PostMapping("loadMenuInfo")
	public ResultMap loadMenuInfo(final HttpServletRequest request) {
		String token = request.getHeader(tokenHead);
		JSONArray array = securityService.loadMenuInfo(token);
		return success(array);
	}
	
	@RequestMapping("loadJWTInfo")
	public Map<String, Object> loadJWTInfo(@RequestParam("token")String token) {
		return securityService.loadJWTInfo(token);
	}
	
	@RequestMapping(value="loadAllPermissions")
	List<Map<String, Object>> getAllPermissionInfo() {
		return securityService.loadAllPermission();
	}
	
	@RequestMapping(value="loadPermissions/{serialNo}")
	public List<Map<String, Object>> getPermissionByUserSerialNo(@PathVariable("serialNo") String serialNo) {
		return securityService.loadPermissionByUserSerialNo(serialNo);
	}
	
}
