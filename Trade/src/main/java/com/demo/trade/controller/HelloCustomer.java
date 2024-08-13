package com.demo.trade.controller;

import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
@CloudComponent
public class HelloCustomer {
    //指定队列
    @RabbitListener(queuesToDeclare = @Queue("hello"))
    public void receive1(String msg){
        System.out.println("-------msg1: "+msg);
    }

    //指定队列
    @RabbitListener(queuesToDeclare = @Queue("hello"))
    public void receive2(String msg){
        System.out.println("-------msg2: "+msg);
    }
}
