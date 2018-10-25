package org.arain.spring.common.inside.base.auth.entity;

import org.arain.spring.common.inside.base.entity.MetaEntity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 *
 * @author Arain
 * @date 2018年10月18日 下午1:46:45
 */
@TableName("sys_menu")
public class SysMenu extends MetaEntity {
	
	private static final long serialVersionUID = 7167276198904470807L;
	
	@TableId
	private Long id;
	
	private String title;
	
	private Integer state;
	
	private String type;
	
	private String code;
	
	private String systemSerialNo;
	
	private String description;
	
	private String createUser;
	
	private String pSerialNo;
	
	private String path;
	
	private String href;
	
	private String icon;
	
	private Integer sort;

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSystemSerialNo() {
		return systemSerialNo;
	}

	public void setSystemSerialNo(String systemSerialNo) {
		this.systemSerialNo = systemSerialNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getpSerialNo() {
		return pSerialNo;
	}

	public void setpSerialNo(String pSerialNo) {
		this.pSerialNo = pSerialNo;
	}
}
