package org.arain.spring.common.inside.result;

import java.io.Serializable;
/**
 * 
 * @author arain
 * @date 2018年9月12日 下午12:40:29
 */
public class ResultMap implements Serializable{

	private static final long serialVersionUID = 8625781887140450294L;

	// 响应业务状态
    private Integer code;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public static ResultMap build(Integer code, String msg, Object data) {
        return new ResultMap(code, msg, data);
    }

    public static ResultMap ok(Object data) {
        return new ResultMap(data);
    }

    public static ResultMap ok() {
        return new ResultMap(null);
    }

    public ResultMap() {

    }

    public static ResultMap build(Integer code, String msg) {
        return new ResultMap(code, msg, null);
    }

    public ResultMap(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultMap(Object data) {
        this.code = 1;
        this.msg = "OK";
        this.data = data;
    }

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
