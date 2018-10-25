package org.arain.spring.auth.jwt;

/**
 * 
 * @author arain
 * @date 2018年10月18日 下午3:42:09
 */
public class StringHelper {
    public static String getObjectValue(Object obj){
        return obj==null?"":obj.toString();
    }
}
