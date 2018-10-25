package org.arain.spring.auth.service;

import java.util.List;

import org.arain.spring.auth.dto.MenuDto;
import org.arain.spring.common.inside.base.auth.entity.SysMenu;
import org.arain.spring.common.inside.base.service.BaseService;

import com.alibaba.fastjson.JSONArray;

/**
 *
 * @author Arain
 * @date 2018年10月19日 上午9:31:31
 */
public interface SysMenuService extends BaseService<SysMenu,String>{

	JSONArray loadMenuByUserSerialNo(String serialNo);

	List<SysMenu> loadSysMenu();

	List<SysMenu> loadSysMenuByUserSerialNo(String serialNo);

	JSONArray loadResourceList(MenuDto dto);

	SysMenu loadResource(String serialNo);
}
