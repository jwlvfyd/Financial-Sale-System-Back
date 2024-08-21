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
            // 调用 TradeMapper 中的方法获取账户余额
            BigDecimal balance = tradeMapper.getAccountBalance(accountId, customerId);

            // 检查 balance 是否为 null 或者 money 是否大于 balance
            if (balance == null || money.compareTo(balance) > 0) {
                // 如果 balance 为 null 或者 money 大于 balance，返回 400 错误
                response.put("status", 400);
                response.put("msg", "申购异常");
                data.put("swiftNo", null);
            } else {
                // 如果 money 小于等于 balance，继续申购流程
                String swiftNo = tradeMapper.generateSwiftNo();
                int result = tradeMapper.subscribe(accountId, money, productId, customerId, swiftNo);
                response.put("status", 200);
                if (result == 1) {
                    response.put("msg", "申购成功");
                    data.put("swiftNo", swiftNo);
                    response.put("data", data);
                } else {
                    // 如果申购操作失败，也使用 400 错误
                    response.put("status", 400);
                    response.put("msg", "申购失败 - 系统错误");
                    data.put("swiftNo", null);
                }
            }
        } catch (Exception e) {
            // 捕捉可能的异常，并返回 500 服务器错误
            response.put("status", 500);
            response.put("msg", "申购异常 - " + e.getMessage());
            data.put("swiftNo", null);
        }
        response.put("data", data);
        return response;
    }
    @PostMapping("/redeem")
    public Map<String, Object> redeem(
            @RequestParam(value = "accountId") String accountId,
            @RequestParam(value = "share") BigDecimal share,
            @RequestParam(value = "productId") String productId,
            @RequestParam(value = "customerId") String customerId) {
        System.out.println("--------------redeem--------------");
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        try {
            // 调用 TradeMapper 中的方法获取所有money的总和
            BigDecimal allMoney = tradeMapper.getAllMoneyForRedeem(accountId, productId, customerId);

            // 检查 share 是否大于 allMoney，或者 allMoney 是否为空，或者 share 是否等于 0
            if (share.compareTo(allMoney) > 0 || allMoney == null || BigDecimal.ZERO.compareTo(share) == 0) {
                // 如果 share 大于 allMoney，或者 allMoney 为空，或者 share 等于 0，返回赎回异常
                response.put("status", 400);
                response.put("msg", "赎回异常 - 可赎回金额不足或请求无效");
                data.put("swiftNo", null);
            } else {
                // 如果 share 小于等于 allMoney，继续赎回流程
                String swiftNo = tradeMapper.generateSwiftNo();
                int result = tradeMapper.redeem(accountId, share, productId, customerId, swiftNo);
                response.put("status", 200);
                if (result == 1) {
                    response.put("msg", "赎回成功");
                    data.put("swiftNo", swiftNo);
                    response.put("data", data);
                } else {
                    // 如果赎回操作失败，返回赎回失败
                    response.put("status", 400);
                    response.put("msg", "赎回失败 - 系统错误");
                    data.put("swiftNo", null);
                }
            }
        } catch (Exception e) {
            // 捕捉可能的异常，并返回赎回异常
            response.put("status", 500);
            response.put("msg", "赎回异常 - " + e.getMessage());
            data.put("swiftNo", null);
        }
        response.put("data", data);
        return response;
    }

    // 撤单
    @PostMapping("/cancelorder")
    public Map<String, Object> cancelOrder(@RequestParam(value = "swiftNo") String swiftNo) {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        try {
            TradeMapper tradeMapper = this.tradeMapper; // 获取 TradeMapper bean

            // 检查 swiftNo 是否存在于 tpurchase 或 tredeem 表中
            int purchaseExist = tradeMapper.checkPurchaseExist(swiftNo);
            int redeemExist = tradeMapper.checkRedeemExist(swiftNo);

            if (purchaseExist == 0 && redeemExist == 0) {
                // 如果两个表中都不存在该 swiftNo，撤单失败
                response.put("status", 401);
                response.put("msg", "撤单失败 - 未找到对应的交易记录");
                data.put("swiftNo", swiftNo);
                response.put("data", data);
                return response;
            }

            // 根据存在的表进行操作，这里假设存在即操作，实际可能需要更明确的业务规则
            int updateResult;
            if (purchaseExist > 0) {
                updateResult = tradeMapper.updatePurchaseState(swiftNo);
            } else {
                updateResult = tradeMapper.updateRedeemState(swiftNo);
            }

            if (updateResult > 0) {
                // 记录撤单信息
                int logResult = tradeMapper.logCancellation(swiftNo);
                if (logResult > 0) {
                    response.put("status", 200);
                    response.put("msg", "撤单成功");
                    data.put("swiftNo", swiftNo);
                    response.put("data", data);
                } else {
                    response.put("status", 500);
                    response.put("msg", "撤单记录失败");
                    data.put("swiftNo", swiftNo);
                    response.put("data", data);
                }
            } else {
                response.put("status", 500);
                response.put("msg", "撤单状态更新失败");
                data.put("swiftNo", swiftNo);
                response.put("data", data);
            }
        } catch (Exception e) {
            response.put("status", 500);
            response.put("msg", "撤单异常：" + e.getMessage());
            data.put("swiftNo", swiftNo);
            response.put("data", data);
        }
        return response;
    }
}