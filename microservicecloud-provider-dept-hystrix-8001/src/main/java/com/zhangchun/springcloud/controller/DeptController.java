package com.zhangchun.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhangchun.springcloud.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import com.zhangchun.springcloud.service.DeptService;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;


    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallBack")
    public Dept get(@PathVariable("id") Long id){


        Dept dept = deptService.get(id);

        if (dept == null){
            throw new RuntimeException("id：" + id + "无效");
        }

        return dept;
    }

    public Dept fallBack(@PathVariable("id") Long id){

        Dept errorObj = new Dept();
        errorObj.setDeptno(id);
        errorObj.setDname("该ID：" + id + "没有对应信息,null--@HystrixCommand");
        errorObj.setDb_source("no this detabase in MySQL");

        return errorObj;

    }



}
