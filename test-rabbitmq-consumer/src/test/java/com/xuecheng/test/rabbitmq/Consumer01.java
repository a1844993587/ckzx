package com.xuecheng.test.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * 入门程序消费者
 *
 * @author Alex Yu
 * @date 2019/9/13 12:45
 */
public class Consumer01 {

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
        try {
            connection = connectionFactory.newConnection();
            // 设置创建会话通道 生产者和mq服务通信都在这里完成
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE, true, false, false, null);
            DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
                // 当接收到消息后 此方法将会调用
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    // 交换机
                    String exchange = envelope.getExchange();
                    // 消息id mq在channel中用来表示消费的id 可用于确认消息已接受
                    long deliveryTag = envelope.getDeliveryTag();
                    String message = new String(body, "utf-8");
                    System.out.println("###receive message : " + message);
                }
            };
            // 监听队列
            channel.basicConsume(QUEUE, true, defaultConsumer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
