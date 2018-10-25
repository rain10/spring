package org.arain.spring.common.inside.base.auth.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.arain.spring.common.inside.base.auth.entity.SysMenu;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 *
 * @author Arain
 * @date 2018年10月18日 下午2:23:30
 */

public interface SysMenuMapper extends BaseMapper<SysMenu>{

	List<SysMenu> selectByUserSerialNoAndPSerialNo(@Param("userSerialNo")String userSerialNo, @Param("pSerialNo")String pSerialNo);

	List<SysMenu> selectByByUserSerialNo(@Param("userSerialNo")String serialNo);

	List<SysMenu> selectByPSerialNo(@Param("serialNo")String serialNo);

}
