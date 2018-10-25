package org.arain.spring.auth.controller;

import java.util.Date;
import java.util.List;

import org.arain.spring.auth.dto.ElementDto;
import org.arain.spring.auth.dto.MenuDto;
import org.arain.spring.auth.service.SysElementService;
import org.arain.spring.auth.service.SysMenuService;
import org.arain.spring.auth.utils.AppUtils;
import org.arain.spring.common.inside.base.auth.entity.SysElement;
import org.arain.spring.common.inside.base.auth.entity.SysMenu;
import org.arain.spring.common.inside.result.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author Arain
 * @date 2018年10月22日 上午8:46:14
 */
@RestController
@RequestMapping("resource")
public class SysResourceController extends AuthController{
	
	@Autowired
	private SysMenuService sysMenuService;
	
	@Autowired
	private SysElementService sysElementService;
	
	@PostMapping("loadResourceList")
	public ResultMap loadResourceList(MenuDto dto) {
		JSONArray array = sysMenuService.loadResourceList(dto);
		return success(array);
	}
	
	@PostMapping("loadMenuAndElements")
	public ResultMap loadResource(MenuDto dto) {
		SysMenu menu = sysMenuService.loadResource(dto.getSerialNo());
		List<SysElement> element = sysElementService.loadResource(dto.getSerialNo());
		JSONObject object = new JSONObject();
		object.put("menu", menu);
		object.put("element", element);
		return success(object);
	}
	
	@PostMapping("saveMenu")
	public ResultMap saveMenu(MenuDto dto) {
		SysMenu menu = new SysMenu();
		AppUtils.copyProperties(menu, dto);
		menu.setCreateDate(new Date());
		menu.setUpdateDate(new Date());
		sysMenuService.insert(menu);
		return success();
	}
	
	@PostMapping("saveElement")
	public ResultMap saveElement(ElementDto dto) {
		SysElement element = new SysElement();
		AppUtils.copyProperties(element, dto);
		element.setCreateDate(new Date());
		element.setUpdateDate(new Date());
		sysElementService.insert(element);
		return success();
	}
	
	@PostMapping("loadElement")
	public ResultMap loadElement(ElementDto dto) {
		SysElement element = sysElementService.loadElementBySerialNo(dto.getSerialNo());
		return success(element);
	}
	
}
