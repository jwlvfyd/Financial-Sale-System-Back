package com.demo.service;

import com.hundsun.jrescloud.common.boot.CloudApplication;
import com.hundsun.jrescloud.common.boot.CloudBootstrap;
import com.hundsun.jrescloud.db.core.configuration.EnableCloudDataSource;
import tk.mybatis.spring.annotation.MapperScan;

@CloudApplication
@EnableCloudDataSource
public class DemoServerStarter {
    public static void main(String[] args) {
        CloudBootstrap.run(DemoServerStarter.class, args);
    }
}
