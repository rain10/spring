package org.arain.spring.auth.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.arain.spring.auth.dto.SecurityDto;
import org.arain.spring.auth.jwt.IJWTInfo;
import org.arain.spring.auth.jwt.JWTInfo;
import org.arain.spring.auth.jwt.JwtTokenUtil;
import org.arain.spring.auth.service.SecurityService;
import org.arain.spring.auth.service.SysElementService;
import org.arain.spring.auth.service.SysMenuService;
import org.arain.spring.auth.service.SysUserService;
import org.arain.spring.common.external.utils.BaseCache;
import org.arain.spring.common.inside.base.auth.entity.SysElement;
import org.arain.spring.common.inside.base.auth.entity.SysMenu;
import org.arain.spring.common.inside.base.auth.entity.SysUser;
import org.arain.spring.common.inside.base.constants.BaseConstants;
import org.arain.spring.common.inside.base.exception.RunException;
import org.arain.spring.common.inside.base.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author Arain
 * @date 2018年10月18日 上午11:19:05
 */
@Service
public class SecurityServiceImpl extends  BaseServiceImpl<SysUser, String> implements SecurityService{
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private SysUserService sysUserService;
	
	@Autowired
	private SysMenuService sysMenuService;
	
	@Autowired
	private SysElementService sysElementService;
	
	@Autowired
	private BaseCache baseCache;
	
	@Value("${token-expire}")
	private int expire;
	
	@Override
	public JSONObject login(SecurityDto dto) {
		SysUser sysUser = sysUserService.loadOneByUsernameAndPassword(dto.getUsername(), dto.getPassword());
		if(sysUser == null) {
			throw new RunException("账号或密码错误");
		}
		try {
			String accessToken = jwtTokenUtil.generateToken(new JWTInfo(sysUser.getUsername()
					, sysUser.getSerialNo()
					, sysUser.getRealname()
					, sysUser.getHeadImage()
					, sysUser.getRegion()));
			
			JSONObject token = new JSONObject();
			token.put("access_token", accessToken);
			baseCache.set(accessToken, accessToken, expire);
			return token;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RunException("用户token生成失败，请重新登录");
		}
	}


	@Override
	public SecurityDto loadUserInfo(String token,SecurityDto dto) {
		try {
				IJWTInfo info = jwtTokenUtil.getInfoFromToken(token);
				if(info != null) {
					dto.setHeadImage(info.getHead());
					dto.setUsername(info.getUniqueName());
					dto.setRegion(info.getRegion());
					dto.setRealname(info.getName());
					return dto;
				}
			throw new RunException("用户token过期或失效，请重新登录");
		} catch (Exception e) {
			throw new RunException("用户token过期或失效，请重新登录");
		}
	}


	@Override
	public JSONArray loadMenuInfo(String token) {
		JSONArray list = new JSONArray();;
		try {
			IJWTInfo info = jwtTokenUtil.getInfoFromToken(token);
			if(info != null) {
				String serialNo = info.getSerialNo();
				list = sysMenuService.loadMenuByUserSerialNo(serialNo);
			}
		} catch (Exception e) {
			throw new RunException("用户token过期或失效，请重新登录");
		}
		return list;
	}


	@Override
	public Map<String, Object> loadJWTInfo(String token) {
		Map<String, Object> map = new HashMap<>();
		String newToken = null;
		Object object = baseCache.get(token);
		if(!StringUtils.isEmpty(object)) {
			newToken = (String) object;
			IJWTInfo info = null;
			try {
				info = jwtTokenUtil.getInfoFromToken(newToken);
				if(info != null) {
					String accessToken = jwtTokenUtil.generateToken(new JWTInfo(info.getUniqueName()
							, info.getSerialNo()
							, info.getName()
							, info.getHead()
							, info.getRegion()));
					
					baseCache.set(token, accessToken, expire);
					map.put(BaseConstants.SERIALNO, info.getSerialNo());
					map.put(BaseConstants.ACCESSTOKEN, accessToken);
					return map;
				}
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}


	@Override
	public List<Map<String, Object>> loadAllPermission() {
		List<Map<String, Object>> list = new ArrayList<>();
		List<SysMenu> menuList = sysMenuService.loadSysMenu();
		for (SysMenu sysMenu : menuList) {
			Map<String, Object> map = new HashMap<>();
			map.put(BaseConstants.CODE, sysMenu.getCode());
			map.put(BaseConstants.URL, sysMenu.getHref());
			map.put(BaseConstants.METHOD,null);
			list.add(map);
		}
		List<SysElement> elemantList = sysElementService.loadSysElement();
		for (SysElement sysElement : elemantList) {
			Map<String, Object> map = new HashMap<>();
			map.put(BaseConstants.CODE, sysElement.getCode());
			map.put(BaseConstants.URL, sysElement.getUri());
			map.put(BaseConstants.METHOD,sysElement.getMethod());
			list.add(map);
		}
		return list;
	}


	@Override
	public List<Map<String, Object>> loadPermissionByUserSerialNo(String serialNo) {
		List<Map<String, Object>> list = new ArrayList<>();
		List<SysMenu> menuList = sysMenuService.loadSysMenuByUserSerialNo(serialNo);
		for (SysMenu sysMenu : menuList) {
			Map<String, Object> map = new HashMap<>();
			map.put(BaseConstants.CODE, sysMenu.getCode());
			map.put(BaseConstants.URL, sysMenu.getHref());
			map.put(BaseConstants.METHOD,null);
			list.add(map);
		}
		
		List<SysElement> elemantList = sysElementService.loadSysElementByUserSerialNo(serialNo);
		for (SysElement sysElement : elemantList) {
			Map<String, Object> map = new HashMap<>();
			map.put(BaseConstants.CODE, sysElement.getCode());
			map.put(BaseConstants.URL, sysElement.getUri());
			map.put(BaseConstants.METHOD,sysElement.getMethod());
			list.add(map);
		}
		return list;
	}


	@Override
	public void logout(String token) {
		baseCache.del(token);
	}

}
