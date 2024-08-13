package com.demo.api;

import com.hundsun.jrescloud.rpc.annotation.CloudFunction;
import com.hundsun.jrescloud.rpc.annotation.CloudService;

/**
 * 基金产品服务
 */
@CloudService
public interface ProductService {
    //value选择类似2024300,2024301,此方法可删
    @CloudFunction(value = "2024300")
    public void test();
}
