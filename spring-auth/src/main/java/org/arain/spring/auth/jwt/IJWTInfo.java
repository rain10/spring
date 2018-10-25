package org.arain.spring.auth.jwt;

/**
 * 
 * @author arain
 * @date 2018年10月22日 下午2:53:27
 */
public interface IJWTInfo {
    /**
     * 获取用户名
     * @return
     */
    String getUniqueName();

    /**
     * 获取用户ID
     * @return
     */
    String getSerialNo();

    /**
     * 获取真实名
     * @return
     */
    String getName();
    
    /**
     * 获取头像
     * @return
     */
    String getHead();
    
    /**
     * 获取区域
     * @return
     */
    String getRegion();
}
