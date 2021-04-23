package com.penguins.cloud.stream.rocketmq.batch.simple;

import com.penguins.cloud.stream.rocketmq.config.JmsConfig;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * @author zhengbing
 * @date 2021/4/20 14:02
 * @email mydreambing@126.com
 */
public class ConsumerBatch {

  private static final String GROUP = "batch_consumer_group";
  private static final String TOPIC = "batch_simple_topic";

  public ConsumerBatch() throws MQClientException, InterruptedException {
    DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(GROUP);
    consumer.setNamesrvAddr(JmsConfig.NAME_SRV);
    // 消费端最多消费数量，默认为1
    consumer.subscribe(TOPIC, "*");
    consumer.setConsumeMessageBatchMaxSize(5);

    consumer.registerMessageListener(
        (MessageListenerConcurrently)
            (msgs, context) -> {
              System.out.println(Thread.currentThread().getName() + "一次收到 " + msgs.size() + " 条消息");
              for (int i = 0; i < msgs.size(); i++) {
                System.out.println(new String(msgs.get(i).getBody(), StandardCharsets.UTF_8));
              }
              return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            });
    consumer.start();
    TimeUnit.SECONDS.sleep(120);
    consumer.shutdown();
  }

  public static void main(String[] args) throws InterruptedException, MQClientException {
    new ConsumerBatch();
  }
}
