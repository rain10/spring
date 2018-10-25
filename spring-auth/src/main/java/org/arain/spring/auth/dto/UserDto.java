package org.arain.spring.auth.dto;

import org.apache.commons.lang3.StringUtils;
import org.arain.spring.common.inside.base.auth.entity.SysUser;
import org.arain.spring.common.inside.base.dto.BaseDto;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * @author Arain
 * @date 2018年10月22日 上午8:50:54
 */
public class UserDto extends BaseDto<SysUser> {

    private static final long serialVersionUID = 5969512566245322454L;

    private String serialNo;

    private String username;

    private String phone;
    
    private String createUser;
    

    public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public Wrapper<SysUser> createPageQueryWrappe() {
        LambdaQueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>().lambda();
        if (StringUtils.isNotBlank(username)) {
            queryWrapper.like(SysUser::getUsername, username);
        }
        if (StringUtils.isNotBlank(phone)) {
            queryWrapper.eq(SysUser::getPhone, phone);
        }
        return queryWrapper;
    }
}
