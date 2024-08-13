package com.demo.api;

import com.hundsun.jrescloud.rpc.annotation.CloudFunction;
import com.hundsun.jrescloud.rpc.annotation.CloudService;

/**
 * 日结清算服务
 */
@CloudService
public interface ClearServuce {
    //value选择类似2024100,2024101,此方法可删
    @CloudFunction(value = "2024100")
    public void test();
}
