package com.demo.query.Vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FundShareVo {
    private String customerName;
    private String productName;
    private String productId;
    private String accountId;
    private String accountName;
    private BigDecimal share;
}
