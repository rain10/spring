package org.arain.spring.common.inside.result;
/**
 *
 * @author arain
 * @date 2018年10月17日 上午9:46:34
 */
public enum ResultEnum {
	OK(1)
	,ERROR(0);//错误
	
	private Integer code;
	
	private ResultEnum(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
