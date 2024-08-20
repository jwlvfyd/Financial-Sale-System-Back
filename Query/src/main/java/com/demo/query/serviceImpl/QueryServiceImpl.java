package com.demo.query.serviceImpl;

import com.demo.domain.Result;
import com.demo.query.Util.RedisClientUtil;
import com.demo.query.Vo.AccountVo;
import com.demo.query.Vo.FundShareVo;
import com.demo.query.Vo.TradeVo;
import com.demo.query.dao.QueryMapper;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@CloudComponent
public class QueryServiceImpl implements com.demo.api.QueryService {
    @Autowired
    QueryMapper queryMapper;
    @Autowired
    RedisClientUtil redisClientUtil;

    public void success(Result result,Object data){
        result.setData(data);
        result.setStatus(200);
        result.setMsg("查询成功");
    }

    public void fail(Result result,String msg){
        result.setStatus(400);
        result.setMsg(msg);
    }

    @Override
    public Result getTradeList(Object object) {
        Result result = new Result();
        TradeVo tradeVo = (TradeVo) object;
        String swiftNo = tradeVo.getSwiftNo();
        String customerId = tradeVo.getCustomerId();
        String customerName = tradeVo.getCustomerName();
        if((swiftNo == null || swiftNo.trim().equals(""))&&(customerId == null || customerId.trim().equals(""))&&(customerName == null || customerName.trim().equals(""))){
            fail(result,"查询失败，请输入三个条件之一");
            return result;
        }
        List<TradeVo> tradeVoList = queryMapper.getPurchaseList(tradeVo);
        tradeVoList.forEach((data)->data.setTradeType("申购"));
        List<TradeVo> redeemList = queryMapper.getRedeemList(tradeVo);
        redeemList.forEach((data)->data.setTradeType("赎回"));
        List<TradeVo> resultList = Stream.concat(tradeVoList.stream(),redeemList.stream()).collect(Collectors.toList());
        result.setData(resultList);
        result.setMsg("查询成功");
        result.setStatus(200);
       return result;
    }

    @Override
    public Result getAccountRecord(Object object) {
        Result result = new Result();
        AccountVo accountVo = (AccountVo)object;
        if(accountVo.getAccountId() == null || accountVo.getAccountId().trim().equals("")){
            fail(result,"查询失败，银行卡号为空");
            return result;
        }
        Object redisData = null;
        List<AccountVo> accountVoList = queryMapper.getAccountList(accountVo);
        success(result,accountVoList);
        return result;
    }

    @Override
    public Result getFundShares(Object object) {
        Result result = new Result();
        FundShareVo fundShareVo = (FundShareVo) object;
        String productName = fundShareVo.getProductName();
        String customerId = fundShareVo.getCustomerId();
        String customerName = fundShareVo.getCustomerName();
        if((productName == null || productName.trim().equals(""))&&(customerId == null || customerId.trim().equals(""))&&(customerName == null || customerName.trim().equals(""))){
            fail(result,"查询失败，请输入三个条件之一");
            return result;
        }
        Object redisData = null;
        List<FundShareVo> fundShareVoList = queryMapper.getFundShare(fundShareVo);
        success(result,fundShareVoList);
        return result;
    }
}
