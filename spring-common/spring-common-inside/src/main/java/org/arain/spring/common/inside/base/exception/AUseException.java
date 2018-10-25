package org.arain.spring.common.inside.base.exception;
/**
 * 
 * @author arain
 * @date 2018年10月18日 下午3:49:58
 */
public class AUseException extends RuntimeException{

	private static final long serialVersionUID = 69235051652068024L;
	
	public AUseException() {
	}

	public AUseException(String message, Throwable cause) {
		super(message, cause);
	}

	public AUseException(String message) {
		super(message);
	}

	public AUseException(Throwable cause) {
		super(cause);
	}
}

