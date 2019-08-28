package com.example.helloworld.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "test-jpl")
public class CommentConsumer {

    private final static Logger logger = LoggerFactory.getLogger(CommentConsumer.class);


    @RabbitHandler
    public void receive(String mes) {
        try {
            long startTime = System.currentTimeMillis();
            logger.info("消息中心接收发送请求-> key个数：{}", mes);

            System.out.println(mes);
            long useTime = System.currentTimeMillis() - startTime;
            logger.info("处理完毕，耗时 {}毫秒", useTime);
        } catch (Exception e) {
            logger.error("调用处理完毕，耗时 {}毫秒", e.getMessage());

        }
    }


}
