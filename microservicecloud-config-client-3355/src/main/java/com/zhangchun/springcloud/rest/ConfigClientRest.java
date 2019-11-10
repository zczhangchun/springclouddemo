package com.zhangchun.springcloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;

@RestController
public class ConfigClientRest {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServices;

    @Value("${server.port}")
    private String  port;


    @RequestMapping(value = "/config")
    public String getConfig(){
        String str = "applicationName：" + applicationName + "\t eurekaServices" + eurekaServices + "\t port" + port;
        System.out.println("*******str：" + str);
        return str;
    }
}
