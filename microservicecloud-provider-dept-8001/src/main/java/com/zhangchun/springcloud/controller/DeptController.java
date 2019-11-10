package com.zhangchun.springcloud.controller;

import com.zhangchun.springcloud.model.Dept;
import com.zhangchun.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public Boolean add(@RequestBody Dept dept){
        return deptService.add(dept);
    }


    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list(){
        System.out.println("hello");
        return deptService.list();
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.get(id);

        return dept;
    }

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery(){

        //获取在eureka中所注册的所有服务信息
        List<String> list = discoveryClient.getServices();
        System.out.println("所有服务信息" + list);

        //获取指定的服务所对应的所有实例
        List<ServiceInstance> instances = discoveryClient.getInstances("MICROSERVICESPRINGCLOUD-DEPT");
        for (ServiceInstance instance : instances) {

            System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());

        }

        return this.discoveryClient;

    }
}
