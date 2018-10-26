package org.arain.spring.common.inside.base.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.arain.spring.common.inside.base.dto.BaseDto;
import org.arain.spring.common.inside.base.entity.BaseEntity;
import org.arain.spring.common.inside.base.service.BaseService;
import org.arain.spring.common.inside.base.utils.SerNumUtils;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 
 * @author arain
 * @date 2018年10月25日 下午12:09:05
 * @param <T>
 * @param <PK>
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class BaseServiceImpl<T extends BaseEntity, PK extends Serializable> implements BaseService<T, PK> {

    
	protected BaseMapper mapper = null;

    public void setMapper(BaseMapper mapper) {
        this.mapper = mapper;
    }

    public void generateSerNum(T t) {
        String serialNo = t.getSerialNo();
        if (StringUtils.isNotBlank(serialNo)) {
            t.setSerialNo(SerNumUtils.getSerNum(t));
        }
    }

	@Override
    public int insert(T t) {
        generateSerNum(t);
        Date date = new Date();
        t.setCreateDate(date);
        t.setUpdateDate(date);
        return mapper.insert(t);
    }

    @Override
    public int deleteById(PK id) {
        return mapper.deleteById(id);
    }

   
	@Override
    public int deleteBatchIds(Collection<? extends PK> ids) {
        return mapper.deleteBatchIds(ids);
    }

    @Override
    public int updateById(T t) {
        return mapper.updateById(t);
    }

    @Override
    public T selectById(PK id) {
        return (T) mapper.selectById(id);
    }

    @Override
    public List<T> selectBatchIds(Collection<? extends PK> ids) {
        return mapper.selectBatchIds(ids);
    }

	@Override
    public IPage<T> selectPage(BaseDto queryModel) {
        IPage<T> pages = mapper.selectPage(new Page<>(queryModel.getCurrentPage(), queryModel.getPageSize()), queryModel.getWrapper());
        return pages;
    }

	@Override
	public int updateBySerialNo(T t) {
		LambdaUpdateWrapper<T> updateWrapper = new UpdateWrapper<>(t).lambda().eq(T::getSerialNo, t.getSerialNo());
		return mapper.update(t, updateWrapper);
	}
}
