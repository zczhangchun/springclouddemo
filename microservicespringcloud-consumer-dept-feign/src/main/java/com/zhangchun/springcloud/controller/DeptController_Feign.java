package com.zhangchun.springcloud.controller;

import com.zhangchun.springcloud.client.DeptClient;
import com.zhangchun.springcloud.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController_Feign {

    @Autowired
    private DeptClient deptClient;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept){

        return deptClient.add(dept);

    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){

        return deptClient.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list(){
        return deptClient.list();
    }
}
