package org.arain.spring.auth.service.impl;

import java.util.List;

import org.arain.spring.auth.service.SysElementService;
import org.arain.spring.common.inside.base.auth.entity.SysElement;
import org.arain.spring.common.inside.base.auth.mapper.SysElementMapper;
import org.arain.spring.common.inside.base.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 *
 * @author Arain
 * @date 2018年10月19日 下午2:26:21
 */
@Service
public class SysElementServiceImpl extends BaseServiceImpl<SysElement, String> implements SysElementService{
	
	@Autowired
	private SysElementMapper sysElementMapper;
	
	@Override
	public List<SysElement> loadSysElement() {
		Wrapper<SysElement> queryWrapper = new QueryWrapper<SysElement>()
				.lambda().eq(SysElement::getState, 1);
		List<SysElement> list = sysElementMapper.selectList(queryWrapper);
		return list;
	}

	@Override
	public List<SysElement> loadSysElementByUserSerialNo(String serialNo) {
		List<SysElement> list = sysElementMapper.selectByByUserSerialNo(serialNo);
		return list;
	}

	@Override
	public List<SysElement> loadResource(String serialNo) {
		Wrapper<SysElement> queryWrapper = new QueryWrapper<SysElement>()
				.lambda().eq(SysElement::getMenuSerialNo, serialNo);
		List<SysElement> list = sysElementMapper.selectList(queryWrapper);
		return list;
	}

	@Override
	public SysElement loadElementBySerialNo(String serialNo) {
		Wrapper<SysElement> queryWrapper = new QueryWrapper<SysElement>()
				.lambda().eq(SysElement::getSerialNo, serialNo);
		SysElement element = sysElementMapper.selectOne(queryWrapper);
		return element;
	}

}
