package org.arain.spring.common.inside.base.auth.entity;

import org.arain.spring.common.inside.base.entity.MetaEntity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *
 * @author Arain
 * @date 2018年10月18日 下午2:06:31
 */
@TableName("sys_user_role")
public class SysUserRole extends MetaEntity{
	
	private static final long serialVersionUID = -7471565857006238214L;
	
	@TableId
	private String userSerialNo;
	
	@TableId
	private String roleSerialNo;
	
	private Integer state;

	public String getUserSerialNo() {
		return userSerialNo;
	}

	public void setUserSerialNo(String userSerialNo) {
		this.userSerialNo = userSerialNo;
	}

	public String getRoleSerialNo() {
		return roleSerialNo;
	}

	public void setRoleSerialNo(String roleSerialNo) {
		this.roleSerialNo = roleSerialNo;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
}
