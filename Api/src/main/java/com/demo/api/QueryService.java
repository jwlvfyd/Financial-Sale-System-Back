package com.demo.api;

import com.hundsun.jrescloud.rpc.annotation.CloudFunction;
import com.hundsun.jrescloud.rpc.annotation.CloudService;

/**
 * 查询服务
 */
@CloudService
public interface QueryService {
    //value选择类似2024300,2024301,此方法可删
    @CloudFunction(value = "2024500")
    public void test();
}
