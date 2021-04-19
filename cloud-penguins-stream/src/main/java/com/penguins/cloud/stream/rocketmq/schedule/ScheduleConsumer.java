package com.penguins.cloud.stream.rocketmq.schedule;

import com.penguins.cloud.stream.rocketmq.config.JmsConfig;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * 定时消息 - 消费者
 *
 * @author zhengbing
 * @date 2021/4/19 16:42
 * @email mydreambing@126.com
 */
public class ScheduleConsumer {

  private static final String GROUP = "schedule_consumer_group";
  private static final String TOPIC = "schedule_topic";

  private DefaultMQPushConsumer consumer = null;

  public ScheduleConsumer() throws MQClientException {
    consumer = new DefaultMQPushConsumer(GROUP);
    consumer.setNamesrvAddr(JmsConfig.NAME_SRV);
    consumer.subscribe(TOPIC, "*");
    consumer.registerMessageListener(
        (MessageListenerConcurrently)
            (msgs, context) -> {
              for (MessageExt message : msgs) {
                // Print approximate delay time period
                System.out.println(
                    "Receive message[msgId="
                        + message.getMsgId()
                        + "] "
                        + (System.currentTimeMillis() - message.getStoreTimestamp())
                        + "ms later");
              }
              return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            });

    consumer.start();
  }

  public static void main(String[] args) throws MQClientException {
    new ScheduleConsumer();
  }
}
