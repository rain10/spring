package org.arain.spring.auth.utils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

/**
 * 
 * @author arain
 * @date 2018年10月22日 下午1:07:51
 */
public class AppUtils {
	
	static {
		ConvertUtils.register(new DateConvert(), java.util.Date.class);  
	}
	
	public static void copyProperties(Object target, Object source) {
		try {
			BeanUtils.copyProperties(target, source);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
