package com.demo.api;

import com.hundsun.jrescloud.rpc.annotation.CloudFunction;
import com.hundsun.jrescloud.rpc.annotation.CloudService;

/**
 * 客户服务
 */
@CloudService
public interface AccountService {
    //value选择类似2024200,2024201,此方法可删
    @CloudFunction(value = "2024200")
    public void test();
}
