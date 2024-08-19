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
        result.setMsg("查询成功");
    }

    @Override
    public Result getTradeList(Object object) {
        Result result = new Result();
        TradeVo tradeVo = (TradeVo) object;
        Object redisData = null;
        //当swiftNo不为空，根据订单号查询
        String swiftNo = tradeVo.getSwiftNo();
        if(null != swiftNo && !"".equals(swiftNo)){
            redisData = redisClientUtil.hget("trade",swiftNo);
        }
        if(null != redisData){
           success(result,redisData);
            return result;
        }

        //当startTime和endTime为null时候，在redis中查询
        String name = tradeVo.getCustomerName();
        if(null== tradeVo.getStartTime() && null==tradeVo.getEndTime()){
            if(null != name && !"".equals(name)){
                redisData = redisClientUtil.hget("trade",name);
            }
            if(null != redisData){
                success(result,redisData);
                return result;
            }
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
        Object redisData = null;
        //在redis中查询
        if(null == accountVo.getStartTime() && null == accountVo.getEndTime()){
            if(null != accountVo.getAccountId()){
                redisData = redisClientUtil.hget("account", accountVo.getAccountId());
            }
            if(null != redisData){
                success(result,redisData);
                return result;
            }
        }

        List<AccountVo> accountVoList = queryMapper.getAccountList(accountVo);
        success(result,accountVoList);
        return result;
    }

    @Override
    public Result getFundShares(Object object) {
        Result result = new Result();
        FundShareVo fundShareVo = (FundShareVo) object;
        Object redisData = null;
       //根据redis查询
        if(null == fundShareVo.getProductName()){
            if(null != fundShareVo.getCustomerName()){
                redisData = redisClientUtil.hget("fundShare",fundShareVo.getCustomerName());
            }
            if(null != redisData){
                success(result,redisData);
                return result;
            }
        }

        List<FundShareVo> fundShareVoList = queryMapper.getFundShare(fundShareVo);
        success(result,fundShareVoList);
        return result;
    }
}
