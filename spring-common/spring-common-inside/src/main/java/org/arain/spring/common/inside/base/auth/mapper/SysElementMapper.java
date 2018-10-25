package org.arain.spring.common.inside.base.auth.mapper;
/**
 *
 * @author Arain
 * @date 2018年10月18日 下午2:22:27
 */

import java.util.List;

import org.arain.spring.common.inside.base.auth.entity.SysElement;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface SysElementMapper extends BaseMapper<SysElement>{

	List<SysElement> selectByByUserSerialNo(String serialNo);

}
