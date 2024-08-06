package com.demo.service.impl;

import com.demo.api.MyFirstDemo;
import com.demo.service.dao.TestMapper;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import org.apache.ibatis.annotations.Mapper;

@CloudComponent
public class MyFirstDemoImpl implements MyFirstDemo {
    @Mapper
    private TestMapper testMapper;
    @Override
    public String sayHello() {
        return "Hello summer!";
    }
}
