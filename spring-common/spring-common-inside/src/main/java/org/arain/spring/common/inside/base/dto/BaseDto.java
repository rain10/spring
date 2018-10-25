package org.arain.spring.common.inside.base.dto;

import java.io.Serializable;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
/**
 * 
 * @author arain
 * @date 2018年10月25日 上午9:32:16
 * @param <T>
 */
public class BaseDto<T> implements Serializable {

	private static final long serialVersionUID = 6149257389152988850L;

	private int pageSize = 10;

    private int currentPage = 1;


	public Wrapper<T> createPageQueryWrappe() {
    	Wrapper<T> wrapper  = new QueryWrapper<T>();
    	return wrapper;
    }


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }


	public Wrapper<T> getWrapper() {
        return createPageQueryWrappe();
	}
    
}
