package com.demo.clear.controller;

import com.demo.domain.PurchaseDTO;
import com.demo.domain.UserDTO;
import com.demo.clear.dao.ClearMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tclear")
public class ClearController {
    @Autowired
    ClearMapper clearMapper;
    // 清算
    @PostMapping("/settlement")
    public Map<String, Object> settlement(
            @RequestParam(value = "answers" , required = false) Map<String, Object> answers) {
        System.out.println("--------------settlement--------------");
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        try {
            response.put("status", 200);
            response.put("msg", "清算成功");
            /**data.put("settlement",1111);
             response.put("data", data);*/
            return response;
        } catch (Exception e) {
            response.put("status", 500);
            response.put("msg", "清算异常");
            response.put("data", null);
            System.out.println("清算异常:" + e);
            return response;
        }
    }

    // 重新清算
    @PostMapping("/reprocess")
    public Map<String, Object> reprocess(
            @RequestParam(value = "answers" , required = false) Map<String, Object> answers) {
        System.out.println("--------------reprocess--------------");
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        try {
            response.put("status", 200);
            response.put("msg", "重新清算成功");
            /**data.put("reprocess",1);
             response.put("data", data);*/
            return response;
        } catch (Exception e) {
            response.put("status", 500);
            response.put("msg", "重新清算异常");
            response.put("data", null);
            System.out.println("重新清算异常:" + e);
            return response;
        }
    }
}
