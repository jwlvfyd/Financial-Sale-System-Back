package com.demo.api;

import com.hundsun.jrescloud.rpc.annotation.CloudFunction;
import com.hundsun.jrescloud.rpc.annotation.CloudService;

/**
 * 交易服务
 */
@CloudService
public interface TradeService {
    //value选择类似2024300,2024301,此方法可删
    @CloudFunction(value = "2024400")
    public void test();
}
