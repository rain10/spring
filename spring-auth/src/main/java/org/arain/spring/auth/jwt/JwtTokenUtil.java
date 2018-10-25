package org.arain.spring.auth.jwt;

import org.arain.spring.auth.config.key.KeyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @author arain
 * @date 2018年10月22日 下午2:53:37
 */
@Component
public class JwtTokenUtil {

    @Value("${token-expire}")
    private int expire;
    
    @Value("${refresh-token-expire}")
    private int refresh;
    
    @Autowired
    private KeyConfiguration keyConfiguration;


    public String generateToken(IJWTInfo jwtInfo) throws Exception {
        return JWTHelper.generateToken(jwtInfo, keyConfiguration.getUserPriKey(),expire);
    }
    
    public String generateRefreshToken(IJWTInfo jwtInfo) throws Exception {
        return JWTHelper.generateToken(jwtInfo, keyConfiguration.getUserPriKey(),refresh);
    }

    public IJWTInfo getInfoFromToken(String token) throws Exception {
        return JWTHelper.getInfoFromToken(token, keyConfiguration.getUserPubKey());
    }


}
