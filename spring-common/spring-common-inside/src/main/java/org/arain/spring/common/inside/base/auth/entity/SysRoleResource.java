package org.arain.spring.common.inside.base.auth.entity;

import org.arain.spring.common.inside.base.entity.MetaEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 *
 * @author Arain
 * @date 2018年10月18日 下午2:08:40
 */
@TableName("sys_role_resource")
public class SysRoleResource extends MetaEntity{
	
	private static final long serialVersionUID = 7352156588275239515L;

	Long id;
	
	String roleSerialNo;
	
	Integer type;
	
	String menuSerialNo;
	
	String elementSerialNo;
	
	Integer state;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoleSerialNo() {
		return roleSerialNo;
	}
	public void setRoleSerialNo(String roleSerialNo) {
		this.roleSerialNo = roleSerialNo;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getMenuSerialNo() {
		return menuSerialNo;
	}
	public void setMenuSerialNo(String menuSerialNo) {
		this.menuSerialNo = menuSerialNo;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	
}
