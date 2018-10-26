package org.arain.spring.common.inside.base.auth.entity;

import org.arain.spring.common.inside.base.entity.MetaEntity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 *
 * @author Arain
 * @date 2018年10月18日 下午2:01:32
 */
@TableName("sys_element")
public class SysElement extends MetaEntity{
	
	private static final long serialVersionUID = -8298179896231113703L;

	private Long id;
	
	private String name;
	
	private String type;
	
	private String uri;
	
	private String method;
	
	private String description;
	
	private String menuSerialNo;
	
	private String createUser;
	
	private Integer state;
	
	private String code;
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMenuSerialNo() {
		return menuSerialNo;
	}

	public void setMenuSerialNo(String menuSerialNo) {
		this.menuSerialNo = menuSerialNo;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
}
