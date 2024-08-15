package com.demo.customer.controller;

import com.demo.customer.dao.AccountMapper;
import com.demo.domain.FundsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/taccount")
public class AccountController {
    @Autowired
    AccountMapper accountMapper;
    @PostMapping("/riskassessment")
    public Map<String, Object> riskassessment(
            @RequestParam(value = "answers" , required = false) Map<String, Object> answers) {
        System.out.println("--------------riskassessment--------------");
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        try {
            response.put("status", 200);
            response.put("msg", "风险评估成功");
            data.put("riskLevel",1);
            response.put("data", data);
            return response;
        } catch (Exception e) {
            response.put("status", 500);
            response.put("msg", "风险评估异常");
            response.put("data", null);
            System.out.println("账户创建异常:" + e);
            return response;
        }
    }


    @PostMapping("/addcard")
    public Map<String, Object> addcard(
            @RequestParam(value = "customerId") String customerId,
            @RequestParam(value = "accountId") String accountId,
            @RequestParam(value = "bankName") String bankName) {

        System.out.println("--------------addcard--------------");
        Map<String, Object> response = new HashMap<>();
        try {
            int result =accountMapper.addCardDTO(customerId,accountId,bankName);
            if (result ==1) {
                response.put("status", 200);
                response.put("msg", "银行卡添加成功");
                response.put("data", null);
            } else {
                response.put("status", 400);
                response.put("msg", "银行卡添加成功失败");
                response.put("data", null);
            }
            return response;
        } catch (Exception e) {
            response.put("status", 500);
            response.put("msg", "银行卡添加异常");
            response.put("data", null);
            System.out.println("银行卡添加异常:" + e);
        }
        return response;
    }


    @PostMapping("/recharge")
    public Map<String, Object> recharge(
            @RequestParam(value = "customerId") String customerId,
            @RequestParam(value = "accountId") String accountId,
            @RequestParam(value = "amount") String amount) {

        System.out.println("--------------recharge--------------");
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        try {
            int result =accountMapper.accountChangedDTO(customerId,accountId,amount);
            if (result ==1) {
                response.put("status", 200);
                response.put("msg", "充值成功");
                data.put("newBalance",amount);
                response.put("data", data);
            } else {
                response.put("status", 400);
                response.put("msg", "充值失败");
                response.put("data", null);
            }
            return response;
        } catch (Exception e) {
            response.put("status", 500);
            response.put("msg", "充值异常");
            response.put("data", null);
            System.out.println("充值异常:" + e);
        }
        return response;
    }


}
