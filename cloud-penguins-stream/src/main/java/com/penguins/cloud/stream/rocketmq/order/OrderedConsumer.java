package com.penguins.cloud.stream.rocketmq.order;

import com.penguins.cloud.stream.rocketmq.config.JmsConfig;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

/**
 * @author zhengbing
 * @date 2021/4/19 00:00
 * @email mydreambing@126.com
 */
public class OrderedConsumer {

  private static final Logger log = LoggerFactory.getLogger(OrderedConsumer.class);
  /** 消费者实体对象 */
  private DefaultMQPushConsumer consumer;

  public OrderedConsumer() throws Exception {
    consumer = new DefaultMQPushConsumer("ordered_consumer_group");

    consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
    // TODO 这里真的是个坑,我product设置VipChannelEnabled(false)，但消费者并没有设置这个参数，之前发送普通消息的时候也没有问题。能正常消费。
    // TODO 但在顺序消息时，consumer一直不消费消息了，找了好久都没有找到原因，直到我这里也设置为VipChannelEnabled(false)，竟然才可以消费消息。
    consumer.setNamesrvAddr(JmsConfig.NAME_SRV);
    consumer.setVipChannelEnabled(false);

    consumer.subscribe("ordered_topic", "*");

    consumer.registerMessageListener(
        // 注册消费的监听 这里注意顺序消费为MessageListenerOrderly 之前并发为ConsumeConcurrentlyContext
        (MessageListenerOrderly)
            (msgs, context) -> {
              MessageExt msg = msgs.get(0);

              // 消费者获取消息 这里只输出 不做后面逻辑处理
              log.info(
                  "Consumer-线程名称={},消息={}",
                  Thread.currentThread().getName(),
                  new String(msg.getBody(), StandardCharsets.UTF_8));
              return ConsumeOrderlyStatus.SUCCESS;
            });
    consumer.start();
  }

  public static void main(String[] args) throws Exception {
    new OrderedConsumer();
  }
}
