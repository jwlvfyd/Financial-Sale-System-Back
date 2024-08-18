package com.demo.api;

import com.demo.domain.Result;
import com.hundsun.jrescloud.rpc.annotation.CloudFunction;
import com.hundsun.jrescloud.rpc.annotation.CloudService;

/**
 * 查询服务
 */
@CloudService
public interface QueryService {
    //value选择类似2024300,2024301,此方法可删

    /**
     * 查询申购、赎回交易
     * @param object 参数信息
     * @return
     */
    @CloudFunction(value = "2024500")
    public Result getTradeList(Object object);

    @CloudFunction(value = "2024501")
    public Result getAccountRecord(Object object);

    @CloudFunction(value = "2024502")
    public Result getFundShares(Object object);
}
