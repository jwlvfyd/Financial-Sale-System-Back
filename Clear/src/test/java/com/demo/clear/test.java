package com.demo.clear;
import com.demo.clear.Util.RedisClientUtil;
import com.demo.clear.dao.TestMapper;
import com.demo.domain.UserDTO;
import com.github.pagehelper.PageHelper;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import org.apache.log4j.Logger;

import java.util.Arrays;

@CloudComponent
@SpringBootTest(classes = ClearStarter.class)
@RunWith(SpringRunner.class)
public class test {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    TestMapper testMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisClientUtil redisClientUtil;

    @Autowired
    RabbitTemplate rabbitTemplate;

    private static Logger logger = Logger.getLogger(test.class);
    @Test
    public void contextLoads() {
        UserDTO user =new UserDTO();
        user.setName("张三");
        user.setPassword("123456");
        redisClientUtil.hset("user","zhangsan",user);
//        Object zhangsan = jsonredisTemplate.opsForValue().get("zhangsan");
//        System.out.println(zhangsan);
        //分页插件使用 // return

         PageHelper.startPage(1,3).doSelectPageInfo(()->testMapper.testUserDTO("张三"));
    }
    @Test
    public void test1(){
        for (int i = 0; i < 5; i++) {
            rabbitTemplate.convertAndSend("hello","hello!!!");
        }
    }
    @Test
    public void test2(){
        logger.info("info信息");
    }
}
