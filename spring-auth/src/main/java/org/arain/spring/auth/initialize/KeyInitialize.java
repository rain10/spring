package org.arain.spring.auth.initialize;

import java.util.Map;

import org.arain.spring.auth.config.key.KeyConfiguration;
import org.arain.spring.auth.jwt.RsaKeyHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
/**
 * 
 * @author arain
 * @date 2018年10月19日 上午8:43:07
 */
@Configuration
@Order(value = 0)
public class KeyInitialize implements CommandLineRunner {

    @Autowired
    private KeyConfiguration keyConfiguration;

    @Override
    public void run(String... args) throws Exception {
            Map<String, byte[]> keyMap = RsaKeyHelper.generateKey(keyConfiguration.getUserSecret());
            keyConfiguration.setUserPriKey(keyMap.get("pri"));
            keyConfiguration.setUserPubKey(keyMap.get("pub"));
    }
}
