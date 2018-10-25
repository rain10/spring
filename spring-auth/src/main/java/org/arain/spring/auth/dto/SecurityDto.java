package org.arain.spring.auth.dto;

import java.io.Serializable;

/**
 *
 * @author Arain
 * @date 2018年10月18日 上午11:19:11
 */
public class SecurityDto implements Serializable{
	
	private static final long serialVersionUID = -5407368298178482271L;

	private String username;
	
	private String password;
	
	private String headImage;
	
	private String region;
	
	private String realname;
	
	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
