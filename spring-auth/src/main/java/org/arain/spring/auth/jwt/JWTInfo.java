package org.arain.spring.auth.jwt;

import java.io.Serializable;

/**
 * 
 * @author arain
 * @date 2018年10月18日 下午3:45:26
 */
public class JWTInfo implements Serializable,IJWTInfo {
	
	private static final long serialVersionUID = 7147660030812183963L;
	
	private String username;
    private String name;
    private String head;
    private String serialNo;
    private String region;
    
    public JWTInfo(String username, String serialNo, String name,String head,String region) {
        this.username = username;
        this.serialNo = serialNo;
        this.name = name;
        this.head = head;
        this.region = region;
    }

    @Override
    public String getUniqueName() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JWTInfo jwtInfo = (JWTInfo) o;

        if (username != null ? !username.equals(jwtInfo.username) : jwtInfo.username != null) {
            return false;
        }
        return serialNo != null ? serialNo.equals(jwtInfo.serialNo) : jwtInfo.serialNo == null;

    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (serialNo != null ? serialNo.hashCode() : 0);
        return result;
    }

	@Override
	public String getHead() {
		return head;
	}

	@Override
	public String getSerialNo() {
		return serialNo;
	}

	@Override
	public String getRegion() {
		return region;
	}
	
	
}
