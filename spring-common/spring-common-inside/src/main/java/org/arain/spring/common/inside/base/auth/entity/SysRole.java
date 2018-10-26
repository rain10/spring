package org.arain.spring.common.inside.base.auth.entity;

import org.arain.spring.common.inside.base.entity.MetaEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 *
 * @author Arain
 * @date 2018年10月18日 下午1:46:53
 */
@TableName("sys_role")
public class SysRole extends MetaEntity{
	
	private static final long serialVersionUID = -849452552224491845L;
	
	private Long id;
	
	private String name;
	
	private String description;
	
	private String region;
	
	private Integer state;
	
	private Integer type;
	
	private String createUser;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
	
}
