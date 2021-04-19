package com.penguins.cloud.stream.rocketmq.simple;

import com.penguins.cloud.stream.rocketmq.config.JmsConfig;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author zhengbing
 * @date 2021/4/16 16:01
 * @email mydreambing@126.com
 */
public class Consumer {

  private static final Logger log = LoggerFactory.getLogger(Consumer.class);

  public static void main(String[] args) throws InterruptedException, MQClientException {

    // Instantiate with specified consumer group name.
    DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("one_way_group");

    // Specify name server addresses.
    consumer.setNamesrvAddr(JmsConfig.NAME_SRV);

    // Subscribe one more more topics to consume.
    consumer.subscribe("one_way_topic", "*");
    // Register callback to execute on arrival of messages fetched from brokers.
    consumer.registerMessageListener(
        new MessageListenerConcurrently() {

          @Override
          public ConsumeConcurrentlyStatus consumeMessage(
              List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
            for (Message msg : msgs) {

              // 消费者获取消息 这里只输出 不做后面逻辑处理
              String body = new String(msg.getBody(), StandardCharsets.UTF_8);
              log.info("Consumer-获取消息-主题topic为={}, 消费消息为={}", msg.getTopic(), body);
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
          }
        });
    // Launch the consumer instance.
    consumer.start();

    System.out.printf("Consumer Started.%n");
  }
}
