package org.arain.spring.auth.service;

import java.util.List;
import java.util.Map;

import org.arain.spring.auth.dto.SecurityDto;
import org.arain.spring.common.inside.base.auth.entity.SysUser;
import org.arain.spring.common.inside.base.service.BaseService;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author Arain
 * @date 2018年10月18日 上午11:18:56
 */
public interface SecurityService extends BaseService<SysUser,String>{
	/**
	 * 登录
	 * @param dto
	 * @return
	 */
	JSONObject login(SecurityDto dto);

	/**
	 * 加载用户
	 * @param header
	 * @param dto
	 * @return
	 */
	SecurityDto loadUserInfo(String header, SecurityDto dto);

	/**
	 * 加载菜单
	 * @param token
	 * @return
	 */
	JSONArray loadMenuInfo(String token);

	/**
	 * 加载用户输出
	 * @param token
	 * @return
	 */
	Map<String, Object> loadJWTInfo(String token);

	/**
	 * 加载所有有效权限
	 * @return
	 */
	List<Map<String, Object>> loadAllPermission();

	/**
	 * 加载用户有效权限
	 * @param serialNo
	 * @return
	 */
	List<Map<String, Object>> loadPermissionByUserSerialNo(String serialNo);

	/**
	 * 登出
	 * @param token
	 */
	void logout(String token);

}
