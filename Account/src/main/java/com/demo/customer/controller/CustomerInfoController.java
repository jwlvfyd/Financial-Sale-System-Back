package com.demo.customer.controller;


import com.demo.customer.dao.CustomerInfoMapper;
import com.demo.domain.AccountDTO;
import com.demo.domain.CustomerInfoDTO;
import com.demo.domain.FundsDTO;
import com.hundsun.jrescloud.common.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/taccount")
public class CustomerInfoController {
    @Autowired
    CustomerInfoMapper customerInfoMapper;
    @PostMapping("/register")
    public Map<String, Object> register(
            @RequestParam(value = "customerId") String customerId,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "gender") String gender,
            @RequestParam(value = "contactInfo") String contactInfo,
            @RequestParam(value = "riskLevel", defaultValue = "1")int riskLevel) {

        System.out.println("--------------register--------------");
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        try {
            int result = customerInfoMapper.addCustomerInfoDTO(customerId,name, gender, contactInfo, riskLevel);
            System.out.println("Insert result: " + result);
            if (result == 1) {
                response.put("status", 200);
                response.put("msg", "账户创建成功");
                data.put("customerId",customerId);
                response.put("data", data);
            } else {
                response.put("status", 400);
                response.put("msg", "账户创建失败");
                response.put("data", null);
            }
            return response;
        } catch (Exception e) {
            response.put("status", 500);
            response.put("msg", "账户创建异常");
            response.put("data", null);
            System.out.println("账户创建异常:" + e);
            return response;
        }
    }

    @PostMapping("/select")
    public Map<String, Object> select(
            @RequestParam(value = "customerId", defaultValue = "%") String customerId,
            @RequestParam(value = "name", defaultValue = "%") String name) {

        System.out.println("--------------select--------------");
        Map<String, Object> response = new HashMap<>();
        try {
            List<CustomerInfoDTO> CustomerInfo = customerInfoMapper.selectcustomerInfoDTO(customerId, name);
            response.put("status", 200);
            response.put("msg", "查询成功");
            response.put("data", CustomerInfo);
        } catch (Exception e) {
            response.put("status", 500);
            response.put("msg", "查询异常");
            response.put("data", null);
            System.out.println("查询异常:" + e);
        }
        return response;
    }


    @PostMapping("/query")
    public Map<String, Object> query(
            @RequestParam(value = "customerId") String customerId) {

        System.out.println("--------------query--------------");
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        try {
            List<CustomerInfoDTO> targetCustomerInfo = customerInfoMapper.selectcustomerInfoDTO(customerId,"%");

            List<AccountDTO> CustomerInfo = customerInfoMapper.querycustomerInfoDTO(customerId);
            response.put("status", 200);
            response.put("msg", "查询成功");
            data.put("customerId",targetCustomerInfo.get(0).getCustomerId());
            data.put("name",targetCustomerInfo.get(0).getName());
            data.put("gender",targetCustomerInfo.get(0).getGender());
            data.put("contactInfo",targetCustomerInfo.get(0).getContactInfo());
            data.put("level",targetCustomerInfo.get(0).getRiskLevel());
            data.put("accounts",CustomerInfo);
            response.put("data", data);
        } catch (Exception e) {
            response.put("status", 500);
            response.put("msg", "查询异常");
            response.put("data", null);
            System.out.println("查询异常:" + e);
        }
        return response;
    }
}
