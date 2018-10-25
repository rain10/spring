package org.arain.spring.auth.service.impl;

import java.util.List;

import org.arain.spring.auth.dto.MenuDto;
import org.arain.spring.auth.service.SysMenuService;
import org.arain.spring.common.inside.base.auth.entity.SysMenu;
import org.arain.spring.common.inside.base.auth.mapper.SysMenuMapper;
import org.arain.spring.common.inside.base.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 *
 * @author Arain
 * @date 2018年10月19日 上午9:31:40
 */
@Service
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenu, String> implements SysMenuService{
	
	@Autowired
	private SysMenuMapper sysMenuMapper;
	
	@Override
	public JSONArray loadMenuByUserSerialNo(String userSerialNo) {
		JSONArray array = new JSONArray();
		List<SysMenu> list = sysMenuMapper.selectByUserSerialNoAndPSerialNo(userSerialNo,"-1");
		for (SysMenu sysMenu : list) {
			JSONArray child = new JSONArray();
			JSONObject object = new JSONObject();
			object.put("serialNo", sysMenu.getSerialNo());
			object.put("title", sysMenu.getTitle());
			object.put("icon", sysMenu.getIcon());
			object.put("path", sysMenu.getPath());
			object.put("href", sysMenu.getHref());
			List<SysMenu> listChild = sysMenuMapper.selectByUserSerialNoAndPSerialNo(userSerialNo,sysMenu.getSerialNo());
			for (SysMenu sysMenuChild : listChild) {
				JSONObject objectChiled = new JSONObject();
				objectChiled.put("serialNo", sysMenuChild.getSerialNo());
				objectChiled.put("title", sysMenuChild.getTitle());
				objectChiled.put("icon", sysMenuChild.getIcon());
				objectChiled.put("path", sysMenuChild.getPath());
				objectChiled.put("href", sysMenuChild.getHref());
				child.add(objectChiled);
			}
			object.put("children", child);
			array.add(object);
		}
		return array;
	}

	@Override
	public List<SysMenu> loadSysMenu() {
		Wrapper<SysMenu> queryWrapper = new QueryWrapper<SysMenu>().lambda().eq(SysMenu::getState, 1);
		List<SysMenu> list = sysMenuMapper.selectList(queryWrapper);
		return list;
	}

	@Override
	public List<SysMenu> loadSysMenuByUserSerialNo(String serialNo) {
		List<SysMenu> list = sysMenuMapper.selectByByUserSerialNo(serialNo);
		return list;
	}

	@Override
	public JSONArray loadResourceList(MenuDto dto) {
		JSONArray array = new JSONArray();
		List<SysMenu> list = sysMenuMapper.selectByPSerialNo("-1");
		for (SysMenu sysMenu : list) {
			JSONObject objectParent = new JSONObject();
			JSONArray arrayChild = new JSONArray();
			objectParent.put("title", sysMenu.getTitle());
			objectParent.put("serialNo", sysMenu.getSerialNo());
			List<SysMenu> listChild = sysMenuMapper.selectByPSerialNo(sysMenu.getSerialNo());
			for (SysMenu sysMenuChild : listChild) {
				JSONObject object = new JSONObject();
				object.put("title", sysMenuChild.getTitle());
				object.put("serialNo", sysMenuChild.getSerialNo());
				arrayChild.add(object);
			}
			objectParent.put("children", arrayChild);
			array.add(objectParent);
		}
		return array;
	}

	@Override
	public SysMenu loadResource(String serialNo) {
		Wrapper<SysMenu> queryWrapper = new QueryWrapper<SysMenu>().lambda().eq(SysMenu::getSerialNo, serialNo);
		SysMenu sysMenu = sysMenuMapper.selectOne(queryWrapper);
		return sysMenu;
	}

}
