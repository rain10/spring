package org.arain.spring.auth.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.arain.spring.auth.dto.UserDto;
import org.arain.spring.auth.jwt.IJWTInfo;
import org.arain.spring.auth.service.SysUserService;
import org.arain.spring.common.inside.base.auth.entity.SysUser;
import org.arain.spring.common.inside.result.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 *
 * @author Arain
 * @date 2018年10月22日 上午8:45:20
 */
@RestController
@RequestMapping("user")
public class SysUserController extends AuthController{
	
	@Autowired
	private SysUserService sysUserService;
	
	@Value("${token-header}")
	private String tokenHead;
	
	@PostMapping("loadUserList")
	public ResultMap loadUserList(final HttpServletRequest request,final HttpServletResponse response,final UserDto dto) {
		dto.createPageQueryWrappe();
		IPage<SysUser> iPage = sysUserService.loadUserList(dto);
		return success(iPage);
	}
	
	@PostMapping("saveUser")
	public ResultMap saveUser(final HttpServletRequest request,final HttpServletResponse response,final UserDto dto) {
		String token = request.getHeader(tokenHead);
		IJWTInfo info = this.analysisInfo(token);
		dto.setCreateUser(info.getName());
		sysUserService.saveUser(dto);
		return success();
	}
}
