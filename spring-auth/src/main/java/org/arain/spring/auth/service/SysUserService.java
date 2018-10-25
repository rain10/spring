package org.arain.spring.auth.service;

import org.arain.spring.auth.dto.UserDto;
import org.arain.spring.common.inside.base.auth.entity.SysUser;
import org.arain.spring.common.inside.base.service.BaseService;

import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 *
 * @author Arain
 * @date 2018年10月18日 下午3:01:12
 */
public interface SysUserService extends BaseService<SysUser,String>{

	/**
	 * 通过用户名和密码加载用户
	 * @param username
	 * @param password
	 * @return
	 */
	SysUser loadOneByUsernameAndPassword(String username,String password);

	/**
	 * 用户列表分页查询
	 * @param dto
	 * @return
	 */
	IPage<SysUser> loadUserList(UserDto dto);

	/**
	 * 保存用户
	 * @param dto
	 */
	void saveUser(UserDto dto);
}
