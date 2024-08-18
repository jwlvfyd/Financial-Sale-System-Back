package com.demo.query.controller;

import com.demo.domain.Result;
import com.demo.query.Vo.AccountVo;
import com.demo.query.Vo.FundShareVo;
import com.demo.query.Vo.TradeVo;
import com.demo.query.serviceImpl.QueryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tquery")
public class QueryController {
    @Autowired
    QueryServiceImpl queryService;
    @GetMapping("/trade")
    public Result getTradeList(TradeVo tradeVo){
        return queryService.getTradeList(tradeVo);
    }

    @GetMapping("/account")
    public Result getCardRecord(AccountVo accountVo) {
        return queryService.getAccountRecord(accountVo);
    }

   @GetMapping("/fundshare")
    public Result getFundShares(FundShareVo fundShareVo) {
        return queryService.getFundShares(fundShareVo);
    }
}
