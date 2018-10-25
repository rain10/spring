package org.arain.spring.auth.service;

import java.util.List;

import org.arain.spring.common.inside.base.auth.entity.SysElement;
import org.arain.spring.common.inside.base.service.BaseService;

/**
 *
 * @author Arain
 * @date 2018年10月19日 下午2:26:10
 */
public interface SysElementService extends BaseService<SysElement, String>{
	
	/**
	 * 加载所有有效元素
	 * @return
	 */
	List<SysElement> loadSysElement();

	/**
	 * 更具用户serialNo加载元素
	 * @param serialNo
	 * @return
	 */
	List<SysElement> loadSysElementByUserSerialNo(String serialNo);

	/**
	 * 根据menu serialNo加载元素
	 * @param serialNo
	 * @return
	 */
	List<SysElement> loadResource(String serialNo);

	/**
	 * 根据serialNo加载元素
	 * @param serialNo
	 * @return
	 */
	SysElement loadElementBySerialNo(String serialNo);
	
	
}
