package org.arain.spring.common.inside.base.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;

/**
 * 
 * @author arain
 * @date 2018年10月25日 下午12:04:17
 */
public class BaseEntity implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3582861031289948294L;
	/**
     * 唯一编号
     */
	@TableField(value = "serial_no")
    private String serialNo;
    /**
     * 创建时间
     */
    @TableField("create_date")
    private Date createDate;
    /**
     * 更新时间
     */
    @TableField("update_date")
    private Date updateDate;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
