package com.demo.query.dao;

import com.demo.query.Vo.AccountVo;
import com.demo.query.Vo.FundShareVo;
import com.demo.query.Vo.TradeVo;

import java.util.List;

public interface QueryMapper {
    /**
     * 根据订单或姓名、开始时间、结束时间查询申购交易，可设定查询时间
     * 姓名模糊匹配,开始与结束时间可选
     * @param tradeVo 查询参数
     * @return
     */
    List<TradeVo> getPurchaseList(TradeVo tradeVo);

    /**
     * 根据订单或姓名、开始时间、结束时间查询赎回交易
     * 姓名模糊匹配,开始与结束时间可选
     * @param tradeVo 查询参数
     * @return
     */
    List<TradeVo> getRedeemList(TradeVo tradeVo);

    /**
     * 根据银行卡号、开始时间、结束时间查询银行卡流水记录
     * 开始和结束时间可选
     * @param accountVo 查询参数
     * @return
     */
    List<AccountVo> getAccountList(AccountVo accountVo);

    /**
     * 根据姓名和基金名称查询用户持有基金份额
     * 基金名称可选、模糊查询
     * @param fundShareVo
     * @return
     */
    List<FundShareVo> getFundShare(FundShareVo fundShareVo);
}
