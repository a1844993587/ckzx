package com.xuecheng.test.rabbitmq;

import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 入门程序消费者
 *
 * @author Alex Yu
 * @date 2019/9/13 12:45
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Consumer02 {

    @Autowired
    private RabbitTemplate rabbitTemplate;


}
