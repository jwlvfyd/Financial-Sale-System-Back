package com.demo.client.controller;

import com.demo.api.TestService;
import com.demo.domain.TestUserInfo;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @CloudReference
    private TestService testService;

    @RequestMapping(value = "createUser", method = RequestMethod.GET)
    public String createUser(@RequestParam("name")String username,
                             @RequestParam(value = "address",required = false)String address){
        TestUserInfo userInfo = new TestUserInfo();
        userInfo.setUserName(username);
        userInfo.setUserAddress(address);
        return testService.createUser(userInfo);
    }
}
