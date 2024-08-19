package com.demo.query.Vo;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class TradeVo {
    private String swiftNo;
    //交易类型
    String tradeType;
    //交易时间
    private Long timestamp;
    private String customerName;
    private String customerId;
    private String accountName;
    private String accountId;
    private String productName;
    private String productId;
    private String state;
    //申购金额 or 赎回份额
    private BigDecimal amount;
    //开始时间
    private Long startTime;
    //结束时间
    private  Long endTime;
}
