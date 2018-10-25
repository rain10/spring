package org.arain.spring.common.inside.base.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.arain.spring.common.inside.base.dto.BaseDto;
import org.arain.spring.common.inside.base.entity.BaseEntity;

import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 
 * @author arain
 * @date 2018年10月25日 下午12:07:45
 * @param <T>
 * @param <PK>
 */
public interface BaseService<T extends BaseEntity, PK extends Serializable> {
    /**
     * 新增
     * @param t
     * @return
     */
    int insert(T t);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteById(PK id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteBatchIds(@Param("coll") Collection<? extends PK> ids);

    /**
     * 更新
     * @param t
     * @return
     */
    int updateById(@Param("et") T t);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    T selectById(PK id);

    /**
     * 根据多个id查询
     * @param id
     * @return
     */
    List<T> selectBatchIds(@Param("coll") Collection<? extends PK> id);

    /**
     * 分页查询
     * @param queryModel
     * @return
     */
	@SuppressWarnings("rawtypes")
	IPage<T> selectPage(BaseDto queryModel, T t);

}
