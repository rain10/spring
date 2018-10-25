package org.arain.spring.auth.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.beanutils.Converter;

/**
 *
 * @author Arain
 * @date 2018年10月22日 下午1:14:07
 */
public class DateConvert implements Converter{

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object convert(Class arg0, Object arg1) {  
        if (null == arg1)  
            return null;  
        /** 输入String ,输出Date */  
        if (arg1 instanceof String && arg0 != java.lang.String.class) {  
            String p = (String) arg1;  
            if (p == null || p.trim().length() == 0) {  
                return null;  
            }  
            try {  
  
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
                return df.parse(p.trim());  
            } catch (Exception e) {  
                try {  
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
                    return df.parse(p.trim());  
                } catch (ParseException ex) {  
                    return arg1;  
                }  
            }  
        }/** 输入String ,输出String */  
        else if (arg1 instanceof String && arg0 == java.lang.String.class) {  
            return arg1;  
        }/** 输入Date ,输出String */  
        else if (arg1 instanceof java.util.Date) {  
            try {  
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
                return df.format((java.util.Date) arg1);  
            } catch (Exception e) {  
                return null;  
            }  
        }/** 输入Date ,输出String */  
        else if (arg1 instanceof java.sql.Date) {  
            try {  
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
                return df.format((java.sql.Date) arg1);  
            } catch (Exception e) {  
                return null;  
            }  
        }  
        return null;  
    }  

}
