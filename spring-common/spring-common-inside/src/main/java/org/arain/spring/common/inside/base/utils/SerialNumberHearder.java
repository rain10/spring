package org.arain.spring.common.inside.base.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author arain
 * @date 2018年10月25日 下午12:11:12
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface SerialNumberHearder {
	/**
	 * 前缀
	 */
	String prefix() default "";

	/**
	 * 后缀
	 */
	String suffix() default "";
}
