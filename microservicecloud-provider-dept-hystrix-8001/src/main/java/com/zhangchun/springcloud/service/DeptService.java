package com.zhangchun.springcloud.service;

import com.zhangchun.springcloud.dao.DeptDao;
import com.zhangchun.springcloud.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {

    @Autowired
    private DeptDao deptDao;

    public Boolean add(Dept dept){

        return deptDao.addDept(dept);
    }

    public Dept get(Long id){
        return deptDao.findById(id);
    }


    public List<Dept> list(){
        return deptDao.findAll();
    }
}
