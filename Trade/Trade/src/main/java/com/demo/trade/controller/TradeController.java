package com.demo.trade.controller;

import com.demo.domain.PurchaseDTO;
import com.demo.domain.UserDTO;
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
            @RequestParam(value = "customerId") String customerId,
            @RequestParam(value = "swift") String swift) {
        System.out.println("--------------subscribe--------------");
        Map<String, Object> response = new HashMap<>();
        try {
            int result = tradeMapper.subscribe(accountId, money, productId, customerId,swift);
            response.put("status", 200);
            if (result ==1) {
                response.put("status", 200);
                response.put("msg", "申购成功");
                response.put("data", null);
            } else {
                response.put("status", 400);
                response.put("msg", "申购失败");
                response.put("data", null);
            }
            return response;
        } catch (Exception e) {
            response.put("status", 500);
            response.put("msg", "申购异常");
            response.put("data", null);
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
            @RequestParam(value = "customerId") String customerId,
            @RequestParam(value = "swift") String swift) {
        Map<String, Object> response = new HashMap<>();
        try {
            boolean success = tradeMapper.redeem(accountId, share, productId, customerId,swift);
            response.put("status", 200);
            response.put("msg", success ? "赎回成功" : "赎回失败");
            return response;
        } catch (Exception e) {
            response.put("status", 500);
            response.put("msg", "赎回异常");
            return response;
        }
    }

    // 撤单
    @PostMapping("/cancelorder")
    public Map<String, Object> cancelOrder(
            @RequestParam(value = "swiftNo") String swiftNo) {
        Map<String, Object> response = new HashMap<>();
        try {
            boolean success = tradeMapper.cancelOrder(swiftNo);
            response.put("status", 200);
            response.put("msg", success ? "撤单成功" : "撤单失败");
            return response;
        } catch (Exception e) {
            response.put("status", 500);
            response.put("msg", "撤单异常");
            return response;
        }
    }
}