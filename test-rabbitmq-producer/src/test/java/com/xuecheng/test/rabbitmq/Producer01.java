package com.xuecheng.test.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * rabbitmq的入门程序
 *
 * @author Alex Yu
 * @date 2019/9/13 12:29
 */
public class Producer01 {

    private static final String QUEUE = "helloWorld";

    public static void main(String[] args) {
        // 和mq建立连接
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672); // 端口
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        // 设置虚拟机 一个mq的服务可以设置多个虚拟机 每个虚拟机就相当于独立的mq
        connectionFactory.setVirtualHost("/");
        // 建立连接
        Connection connection = null;
        Channel channel = null;
        try {
            connection = connectionFactory.newConnection();
            // 设置创建会话通道 生产者和mq服务通信都在这里完成
            channel = connection.createChannel();
            // 声明队列
            channel.queueDeclare(QUEUE, true, false, false, null);
            // 发送消息
            String message = "Hello World AlexYu";
            channel.basicPublish("", QUEUE, null, message.getBytes());
            System.out.println("###send to mq");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                channel.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
