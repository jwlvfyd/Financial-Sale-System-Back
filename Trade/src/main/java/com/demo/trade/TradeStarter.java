package com.demo.trade;

import com.hundsun.jrescloud.common.boot.CloudApplication;
import com.hundsun.jrescloud.common.boot.CloudBootstrap;
import com.hundsun.jrescloud.db.core.configuration.EnableCloudDataSource;
import tk.mybatis.spring.annotation.MapperScan;

@CloudApplication
@EnableCloudDataSource
@MapperScan("com.demo.trade.dao")
public class TradeStarter {
    public static void main(String[] args) {
        CloudBootstrap.run(TradeStarter.class, args);
    }
}
