package com.demo.clear;

import com.hundsun.jrescloud.common.boot.CloudApplication;
import com.hundsun.jrescloud.common.boot.CloudBootstrap;
import com.hundsun.jrescloud.db.core.configuration.EnableCloudDataSource;
import tk.mybatis.spring.annotation.MapperScan;

@CloudApplication
@EnableCloudDataSource
@MapperScan("com.demo.clear.dao")
public class ClearStarter {
    public static void main(String[] args) {
        CloudBootstrap.run(ClearStarter.class, args);
    }
}
