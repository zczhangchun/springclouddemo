package com.zhangchun.springcloud.client;

import com.zhangchun.springcloud.client.DeptClient;
import com.zhangchun.springcloud.model.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientFallbackFactory implements FallbackFactory<DeptClient> {


    public DeptClient create(Throwable throwable) {
        return new DeptClient() {
            public boolean add(Dept dept) {
                return false;
            }

            public Dept get(Long id) {
                Dept errorObj = new Dept();
                errorObj.setDeptno(id);
                errorObj.setDname("该ID：" + id + "没有对应信息,null--@HystrixCommand");
                errorObj.setDb_source("no this detabase in MySQL");

                return errorObj;
            }

            public List<Dept> list() {
                return null;
            }
        };
    }
}
