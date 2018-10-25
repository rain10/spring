package org.arain.spring.auth.dto;

import java.io.Serializable;

/**
 *
 * @author Arain
 * @date 2018年10月22日 下午1:44:08
 */
public class MenuDto implements Serializable{
	
	private static final long serialVersionUID = 1661115994948475570L;
	
	private String serialNo;

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	
	
}
