package com.demo.customer.controller;


import com.demo.customer.dao.TestMapper;
import com.demo.domain.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/taccount")
public class TestController {
    @Autowired
    TestMapper testMapper;
    @GetMapping("/test1")
    public UserDTO test(String name){
        System.out.println("--------------test--------------");
        return testMapper.testUserDTO(name);
    }

}
