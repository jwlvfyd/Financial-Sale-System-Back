package com.demo.api;

import com.hundsun.jrescloud.rpc.annotation.CloudFunction;
import com.hundsun.jrescloud.rpc.annotation.CloudService;
import com.demo.dto.TestUserInfo;

@CloudService
public interface TestService {
    @CloudFunction(value = "30001")
    String createUser(TestUserInfo testUserInfo);
}
