package com.penguins.cloud.stream.rocketmq.broadcasting;

import com.penguins.cloud.stream.rocketmq.config.JmsConfig;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

/**
 * @author zhengbing
 * @date 2021/4/19 15:04
 * @email mydreambing@126.com
 */
public class BroadCastingConsumer {

  public BroadCastingConsumer() throws MQClientException {
    DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer_topic_broad");
    consumer.setNamesrvAddr(JmsConfig.NAME_SRV);
    consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

    // 设置消息模式为  广播模式
    consumer.setMessageModel(MessageModel.BROADCASTING);

    consumer.subscribe("broad_casting_topic", "*");

    consumer.registerMessageListener(
        (MessageListenerConcurrently)
            (msgs, context) -> {
              System.out.printf(
                  Thread.currentThread().getName() + " Receive New Messages: " + msgs + "%n");
              return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            });

    consumer.start();
    System.out.printf("Broadcast Consumer Started.%n");
  }

  public static void main(String[] args) throws MQClientException {
    new BroadCastingConsumer();
  }
}
