package com.zhangchun.springcloud.dao;

import com.zhangchun.springcloud.model.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDao {

    Boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();
}
