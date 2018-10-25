package org.arain.spring.auth.config.key;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
/**
 * 
 * @author arain
 * @date 2018年10月18日 下午3:46:41
 */
@Configuration
public class KeyConfiguration {
	@Value("${user.rsa-secret}")
    private String userSecret;
    private byte[] userPubKey;
    private byte[] userPriKey;
    private byte[] servicePriKey;
    private byte[] servicePubKey;
	public String getUserSecret() {
		return userSecret;
	}
	public void setUserSecret(String userSecret) {
		this.userSecret = userSecret;
	}
	public byte[] getUserPubKey() {
		return userPubKey;
	}
	public void setUserPubKey(byte[] userPubKey) {
		this.userPubKey = userPubKey;
	}
	public byte[] getUserPriKey() {
		return userPriKey;
	}
	public void setUserPriKey(byte[] userPriKey) {
		this.userPriKey = userPriKey;
	}
	public byte[] getServicePriKey() {
		return servicePriKey;
	}
	public void setServicePriKey(byte[] servicePriKey) {
		this.servicePriKey = servicePriKey;
	}
	public byte[] getServicePubKey() {
		return servicePubKey;
	}
	public void setServicePubKey(byte[] servicePubKey) {
		this.servicePubKey = servicePubKey;
	}
    
}
