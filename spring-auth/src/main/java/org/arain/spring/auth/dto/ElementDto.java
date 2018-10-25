package org.arain.spring.auth.dto;

import java.io.Serializable;

/**
 *
 * @author Arain
 * @date 2018年10月22日 下午3:21:20
 */
public class ElementDto implements Serializable{
	
	private static final long serialVersionUID = 3002288618395868073L;

	private String serialNo;
	
	private String name;
	
	private String type;
	
	private String uri;
	
	private String method;
	
	private String description;
	
	private String menuSerialNo;
	
	private String createUser;
	
	private String state;
	
	private String code;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
