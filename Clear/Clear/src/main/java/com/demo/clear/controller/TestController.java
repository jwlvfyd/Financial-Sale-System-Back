package com.demo.clear.controller;

import com.demo.clear.dao.TestMapper;
import com.demo.domain.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tclear")
public class TestController {
    @Autowired
    TestMapper testMapper;
    @GetMapping("/test1")
    public UserDTO test(String name){
        System.out.println("--------------test--------------");
        return testMapper.testUserDTO(name);
    }

}
