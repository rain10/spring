package org.arain.spring.common.inside.base.utils;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author arain
 * @date 2018年10月25日 下午12:11:19
 */
public class SerNumUtils {
	public static int sortNum = 0;

	public synchronized static int getSortNum() {
		sortNum = sortNum % 100;
		synchronized (SerNumUtils.class) {
			return sortNum++;
		}
	}

	/**
	 * 获取随机编号
	 *
	 * @param t
	 * @param <T>
	 * @return
	 *         @
	 */
	public static <T> String getSerNum(T t) {
		Date date = new Date();
		String dateToStr = TimeUtil.format(date, "yyyyMMddHHmmssSSS");
		if (null != t) {
			Class<?> aClass = t.getClass();
			SerialNumberHearder annotation = aClass.getAnnotation(SerialNumberHearder.class);
			if (null == annotation) {
				return dateToStr + getSortNum();
			}
			String prefix = annotation.prefix();
			String suffix = annotation.suffix();
			return prefix + dateToStr + getSortNum() + suffix;
		} else {
			return dateToStr + getSortNum();
		}
	}

	public static String getSerNum() {
		Date date = new Date();
		String dateToStr = TimeUtil.format(date, "yyyyMMddHHmmssSSS");
		return dateToStr + getSortNum();
	}

	/**
	 * 获取前缀
	 */
	public static <T> String getPrefix(T t) {
		Class<?> aClass = t.getClass();
		SerialNumberHearder annotation = aClass.getAnnotation(SerialNumberHearder.class);
		String prefix = annotation.prefix();
		return prefix;
	}

	/**
	 * 获取后缀缀
	 */
	public static <T> String getSuffix(T t) {
		Class<?> aClass = t.getClass();
		SerialNumberHearder annotation = aClass.getAnnotation(SerialNumberHearder.class);
		String suffix = annotation.suffix();
		return suffix;
	}

	public static String getSortNumByDate(Date date) {
		String dateTime = TimeUtil.format(date, "ssSSS");
		int max = 99;
		int min = 0;
		Random random = new Random();

		int s = random.nextInt(max) % (max - min + 1) + min;
		return dateTime + s;
	}


	public static String getRadomNum(){
		Date date = new Date();
		String dateToStr = TimeUtil.format(date, "yyMMddHHmmss");
		return dateToStr + getSortNum();
	}


}
