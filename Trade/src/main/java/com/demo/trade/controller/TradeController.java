package com.demo.trade.controller;

import com.demo.domain.PurchaseDTO;
import com.demo.trade.dao.TradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ttrade")
public class TradeController {
    @Autowired
    TradeMapper tradeMapper;

    // 申购业务
    @PostMapping("/subscribe")
    public Map<String, Object> subscribe(
            @RequestParam(value = "accountId") String accountId,
            @RequestParam(value = "money") BigDecimal money,
            @RequestParam(value = "productId") String productId,
            @RequestParam(value = "customerId") String customerId) {
        System.out.println("--------------subscribe--------------");
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        try {
            int result = tradeMapper.subscribe(accountId, money, productId, customerId);
            response.put("status", 200);
            String swiftNo=tradeMapper.selectsubSwiftNo(accountId, money, productId, customerId);
            if (result ==1) {
                response.put("status", 200);
                response.put("msg", "申购成功");
                data.put("swiftNo",swiftNo);
                response.put("data", data);
            } else {
                response.put("status", 400);
                response.put("msg", "申购失败");
                data.put("swiftNo",null);
                response.put("data", data);
            }
            return response;
        } catch (Exception e) {
            response.put("status", 500);
            response.put("msg", "申购异常");
            data.put("swiftNo",null);
            response.put("data", data);
            System.out.println("插入异常:" + e);
            return response;
        }
    }



    // 赎回业务
    @PostMapping("/redeem")
    public Map<String, Object> redeem(
            @RequestParam(value = "accountId") String accountId,
            @RequestParam(value = "share") BigDecimal share,
            @RequestParam(value = "productId") String productId,
            @RequestParam(value = "customerId") String customerId) {
        System.out.println("--------------subscribe--------------");
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        try {
            int result = tradeMapper.redeem(accountId, share, productId, customerId);
            response.put("status", 200);
            String swiftNo=tradeMapper.selectreSwiftNo(accountId, share, productId, customerId);
            if (result ==1) {
                response.put("status", 200);
                response.put("msg", "赎回成功");
                data.put("swiftNo",swiftNo);
                response.put("data", data);
            } else {
                response.put("status", 400);
                response.put("msg", "赎回失败");
                data.put("swiftNo",null);
                response.put("data", data);
            }
            return response;
        } catch (Exception e) {
            response.put("status", 500);
            response.put("msg", "赎回异常");
            data.put("swiftNo",null);
            response.put("data", data);
            System.out.println("插入异常:" + e);
            return response;
        }
    }


    // 撤单
    @PostMapping("/cancelorder")
    public Map<String, Object> cancelOrder(
            @RequestParam(value = "swiftNo") String swiftNo) {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        try {
            boolean success = tradeMapper.cancelOrder(swiftNo);
            response.put("status", 200);
            response.put("msg", success ? "撤单成功" : "撤单失败");
            data.put("swiftNo",swiftNo);
            response.put("data", data);
            return response;
        } catch (Exception e) {
            response.put("status", 500);
            response.put("msg", "撤单异常");
            return response;
        }
    }
}