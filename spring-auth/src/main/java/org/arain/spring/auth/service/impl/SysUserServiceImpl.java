package org.arain.spring.auth.service.impl;
/**
 *
 * @author Arain
 * @date 2018年10月18日 下午3:01:35
 */

import java.util.Date;

import org.arain.spring.auth.dto.UserDto;
import org.arain.spring.auth.service.SysUserService;
import org.arain.spring.auth.utils.AppUtils;
import org.arain.spring.common.inside.base.auth.entity.SysUser;
import org.arain.spring.common.inside.base.auth.mapper.SysUserMapper;
import org.arain.spring.common.inside.base.service.impl.BaseServiceImpl;
import org.arain.spring.common.inside.base.utils.SerNumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser, String> implements SysUserService{
	
	SysUserMapper sysUserMapper;
	
	@Autowired
	public void setSysUserMapper(SysUserMapper sysUserMapper) {
		this.sysUserMapper = sysUserMapper;
		super.setMapper(sysUserMapper);
	}


	@Override
	public SysUser loadOneByUsernameAndPassword(String username,String password) {
		Wrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>()
				.lambda()
				.eq(SysUser::getUsername, username)
				.eq(SysUser::getPassword, password);
		SysUser sysUser = sysUserMapper.selectOne(queryWrapper);
		return sysUser;
	}


	@Override
	public IPage<SysUser> loadUserList(UserDto dto) {
		IPage<SysUser> iPage = sysUserMapper.selectPage(new Page<>(dto.getCurrentPage(), dto.getPageSize()), dto.getWrapper());	
		return iPage;
	}


	@Override
	public void saveUser(UserDto dto) {
		SysUser sysUser = new SysUser();
		AppUtils.copyProperties(sysUser, dto);
		sysUser.setCreateDate(new Date());
		sysUser.setUpdateDate(new Date());
		sysUser.setSerialNo(SerNumUtils.getRadomNum());
		sysUser.setUsername("arain");
		sysUser.setPassword("123");
		sysUser.setState(1);
		sysUser.setRegion("1");
		sysUser.setRealname("代宇");
		sysUser.setType(1);
		sysUserMapper.insert(sysUser);
	}
}
