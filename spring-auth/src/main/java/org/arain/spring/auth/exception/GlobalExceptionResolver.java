package org.arain.spring.auth.exception;

import org.apache.commons.lang3.StringUtils;
import org.arain.spring.common.inside.base.exception.RunException;
import org.arain.spring.common.inside.result.ResultMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author arain
 * @date 2018年10月18日 下午3:50:45
 */
@ControllerAdvice
public class GlobalExceptionResolver {
	
	private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionResolver.class);
	
	/**
	 * 自定义异常拦截
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = RunException.class)
	@ResponseBody
    public ResultMap customExceptionHandler(RunException e) {
		LOG.error("系统异常信息：{}",e.getMessage());
		if(e.getCode() == null) {
			e.setCode(0);
		}
        return ResultMap.build(e.getCode(), e.getMessage());
    }
	
	/**
	 * 系统EXception拦截
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
    public ResultMap systemExceptionHandler(Exception e) {
		String msg;
		if(StringUtils.isBlank(e.getMessage())) {
			msg = "系统异常";
		}
		msg = e.getMessage();
		LOG.error("系统异常信息：{}",msg);
		return ResultMap.build(0, e.getMessage());
    }
}

