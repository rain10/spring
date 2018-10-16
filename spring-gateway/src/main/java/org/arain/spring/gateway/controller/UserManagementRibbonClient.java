package org.arain.spring.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class UserManagementRibbonClient {
//
//    @Autowired
//    RestTemplate restTemplate;

    @Value("${server.port}")
    String port;

    @GetMapping("test/listUsersByRibbon")
    @HystrixCommand(fallbackMethod="listUsersByRibbonFallback")
    public String listUsersByRibbon(){
		return port;
//        String result = this.restTemplate.getForObject("http://admin/admin/listUsers", String.class);
//        return result;
    }
    
    @RequestMapping("bbb")
    public String listUsersByRibbonFallback(){
        return "listUsersByRibbon异常，端口：" + port;
    }
//    
//    @GetMapping("api/system/aaa")
//    public String listUsersByRibbonFallbaaaack(){
//        return "listUsersByRibbon异常，端口：" + port;
//    }
}