package com.demo.query;

import com.hundsun.jrescloud.common.boot.CloudApplication;
import com.hundsun.jrescloud.common.boot.CloudBootstrap;
import com.hundsun.jrescloud.db.core.configuration.EnableCloudDataSource;
import tk.mybatis.spring.annotation.MapperScan;

@CloudApplication
@EnableCloudDataSource
@MapperScan("com.demo.query.dao")
public class QueryStarter {
    public static void main(String[] args) {
        CloudBootstrap.run(QueryStarter.class, args);
    }
}
