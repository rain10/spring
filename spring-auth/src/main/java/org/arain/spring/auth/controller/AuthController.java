package org.arain.spring.auth.controller;

import org.arain.spring.auth.jwt.IJWTInfo;
import org.arain.spring.auth.jwt.JwtTokenUtil;
import org.arain.spring.common.inside.base.controller.BaseController;
import org.arain.spring.common.inside.base.exception.RunException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Arain
 * @date 2018年10月24日 下午4:12:29
 */
@Component
public class AuthController extends BaseController{
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	public IJWTInfo analysisInfo(final String token) {
		IJWTInfo info = null;
		try {
			info = jwtTokenUtil.getInfoFromToken(token);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RunException("用户token过期或失效，请重新登录");
		}
		return info;
	}
}
