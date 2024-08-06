package com.demo.client;

import com.hundsun.jrescloud.common.boot.CloudApplication;
import com.hundsun.jrescloud.common.boot.CloudBootstrap;

@CloudApplication
public class DemoClientStarter {
    public static void main(String[] args) {
        CloudBootstrap.run(DemoClientStarter.class, args);
    }
}
