package com.demo.client.controller;

import com.demo.api.MyFirstDemo;
import com.demo.api.TestService;
import com.demo.dto.TestUserInfo;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @CloudReference
    private MyFirstDemo myFirstDemo;
    @CloudReference
    private TestService testService;

    @RequestMapping(value ="sayhello", method = RequestMethod.GET)
    public String sayHello(){
        return myFirstDemo.sayHello();
    }

    @RequestMapping(value = "createUser", method = RequestMethod.GET)
    public String createUser(@RequestParam("name")String username,
                             @RequestParam(value = "address",required = false)String address){
        TestUserInfo userInfo = new TestUserInfo();
        userInfo.setUserName(username);
        userInfo.setUserAddress(address);
        return testService.createUser(userInfo);
    }
}
