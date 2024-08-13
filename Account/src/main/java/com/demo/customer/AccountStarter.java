package com.demo.customer;

import com.hundsun.jrescloud.common.boot.CloudApplication;
import com.hundsun.jrescloud.common.boot.CloudBootstrap;
import com.hundsun.jrescloud.db.core.configuration.EnableCloudDataSource;
import tk.mybatis.spring.annotation.MapperScan;

@CloudApplication
@EnableCloudDataSource
@MapperScan("com.demo.customer.dao")
public class AccountStarter {
    public static void main(String[] args) {
        CloudBootstrap.run(AccountStarter.class, args);
    }
}
