package org.arain.spring.common.inside.base.exception;
/**
 * 
 * @author arain
 * @date 2018年10月18日 下午3:50:03
 */
public class RunException extends AUseException{
	
	private static final long serialVersionUID = 2272436087666909144L;

	/**
	 * 异常码
	 */
	private Integer code;
	
	//自定义异常信息
	private String message;
	
	public RunException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	public RunException(String message) {
		super(message);
		this.message = message;
	}

	public RunException(Throwable cause) {
		super(cause);
	}
	/**
	 * 
	 * @param code
	 * @param msg
	 */
	public RunException(String message,Integer code) {
		super(message);
		this.message = message;
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
