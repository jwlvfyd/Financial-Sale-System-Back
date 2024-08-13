package com.demo.service.impl;

import com.demo.api.TestService;
import com.demo.domain.TestUserDTO;
import com.demo.domain.TestUserInfo;
import com.demo.service.dao.TestMapper;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@CloudComponent
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;

    @Override
    public String createUser(TestUserInfo userInfo) {
        if(null  == userInfo){
            throw new IllegalArgumentException("userInfo can not be null");
        }
        if(StringUtils.isBlank(userInfo.getUserName())){
            throw new IllegalArgumentException("user name can not be null");
        }
        TestUserDTO user  = new TestUserDTO();
        user.setUserId(UUID.randomUUID().toString());
        user.setUserName(userInfo.getUserName());
        user.setAddress(userInfo.getUserAddress());
        testMapper.createUser(user);
        return user.getUserId();
    }
}
