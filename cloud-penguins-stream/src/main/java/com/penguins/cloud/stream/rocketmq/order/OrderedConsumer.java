package com.penguins.cloud.stream.rocketmq.order;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zhengbing
 * @date 2021/4/19 00:00
 * @email mydreambing@126.com
 */
public class OrderedConsumer {

  private static final Logger log = LoggerFactory.getLogger(OrderedConsumer.class);

  public static void main(String[] args) throws Exception {

    DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("ordered_group");

    consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
    consumer.setNamesrvAddr("120.25.218.127:9876");

    consumer.subscribe("ordered_topic", "orderTagA || orderTagB || orderTagD ");

    consumer.registerMessageListener(
        new MessageListenerOrderly() {

          AtomicLong consumeTimes = new AtomicLong(0);

          @Override
          public ConsumeOrderlyStatus consumeMessage(
              List<MessageExt> msgs, ConsumeOrderlyContext context) {
            context.setAutoCommit(false);
            for (Message msg : msgs) {

              // 消费者获取消息 这里只输出 不做后面逻辑处理
              String body = new String(msg.getBody(), StandardCharsets.UTF_8);
              log.info("Consumer-获取消息-主题topic为={},消费消息为={}", msg.getTopic(), body);
            }
            this.consumeTimes.incrementAndGet();
            if ((this.consumeTimes.get() % 2) == 0) {
              return ConsumeOrderlyStatus.SUCCESS;
            } else if ((this.consumeTimes.get() % 3) == 0) {
              return ConsumeOrderlyStatus.ROLLBACK;
            } else if ((this.consumeTimes.get() % 4) == 0) {
              return ConsumeOrderlyStatus.COMMIT;
            } else if ((this.consumeTimes.get() % 5) == 0) {
              context.setSuspendCurrentQueueTimeMillis(3000);
              return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
            }
            return ConsumeOrderlyStatus.SUCCESS;
          }
        });

    consumer.start();

    System.out.printf("Consumer Started.%n");
  }
}
