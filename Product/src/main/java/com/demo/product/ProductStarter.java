package com.demo.product;

import com.hundsun.jrescloud.common.boot.CloudApplication;
import com.hundsun.jrescloud.common.boot.CloudBootstrap;
import com.hundsun.jrescloud.db.core.configuration.EnableCloudDataSource;
import tk.mybatis.spring.annotation.MapperScan;

@CloudApplication
@EnableCloudDataSource
@MapperScan("com.demo.product.dao")
public class ProductStarter {
    public static void main(String[] args) {
        CloudBootstrap.run(ProductStarter.class, args);
    }
}
