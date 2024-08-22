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
            @RequestParam(value = "answers") char[] answers) {
        System.out.println("--------------riskassessment--------------");
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        try {
            int ans=0;
            int[][] sorces = {
                    {5, 4, 3, 2},
                    {2, 3, 4, 5},
                    {1, 2, 4, 5},
                    {1, 2, 3, 5},
                    {1, 2, 3, 4, 5},
                    {1, 2, 4, 5},
                    {1, 2, 3, 4, 5},
                    {1, 2, 3, 4, 5},
                    {1, 2, 3, 4, 5},
                    {1, 2, 3, 4, 5},
                    {1, 2, 3, 4, 5},
                    {1, 2, 3, 4, 5},
                    {2, 3, 4, 5},
                    {2, 3, 4, 5},
                    {1, 2, 3, 4, 5},
                    {1, 2, 3, 4, 5},
            };
            System.out.println("答案数组长度" + answers.length);
            for(int i=0;i<answers.length;i++){
                ans+=sorces[i][answers[i]-'A'];
            }
            System.out.println("答案为" + ans);
            if(ans>=20&&ans<=34){
                data.put("riskLevel",1);
                response.put("msg", "极度保守，倾向于保本且极低风险的投资，通常不愿意承受任何亏损。");
            }
            else if(ans>=35&&ans<=46){
                data.put("riskLevel",2);
                response.put("msg", "相对保守，主要追求低风险和稳定的收益，愿意承担有限的风险。");
            }
            else if(ans>=47&&ans<=58){
                data.put("riskLevel",3);
                response.put("msg", "风险承受能力中等，能够接受适度的波动，追求收益和风险的平衡。");
            }
            else if(ans>=59&&ans<=70){
                data.put("riskLevel",4);
                response.put("msg", "具备较高的风险承受能力，期望高于市场平均水平的回报，愿意承担较大的投资风险。");
            }
            else if(ans>=71&&ans<=80){
                data.put("riskLevel",5);
                response.put("msg", "非常积极，追求高风险高回报，愿意接受投资中的大幅波动。");
            }
            else{
                data.put("riskLevel",1);
                response.put("msg", "答案有误，请重新选择！");
            }
            response.put("status", 200);
            response.put("data", data);
            return response;
        } catch (Exception e) {
            response.put("status", 500);
            response.put("msg", "风险评估异常");
            response.put("data", null);
            System.out.println("风险评估异常:" + e);
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
