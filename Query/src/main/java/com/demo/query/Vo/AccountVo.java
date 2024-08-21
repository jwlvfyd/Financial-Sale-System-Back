package com.demo.query.Vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountVo {
    private String accountId;
    private Long startTime;
    private Long endTime;
    private String bankName;
    //支出 or 入账
    private String tradeType;
    private BigDecimal amount;
    private Long changeTime;
}
