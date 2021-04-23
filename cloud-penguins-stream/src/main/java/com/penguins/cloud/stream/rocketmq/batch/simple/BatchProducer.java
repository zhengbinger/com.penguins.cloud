package com.penguins.cloud.stream.rocketmq.batch.simple;

import com.penguins.cloud.stream.rocketmq.config.JmsConfig;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.ArrayList;
import java.util.List;

/**
 * 小数据量的批量消息处理（一次不超过1M）
 *
 * @author zhengbing
 * @date 2021/4/20 11:30
 * @email mydreambing@126.com
 */
public class BatchProducer {

  private static final String GROUP = "batch_simple_group";

  private static final String TOPIC = "batch_simple_topic";

  private DefaultMQProducer producer = null;

  public BatchProducer()
      throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
    producer = new DefaultMQProducer(GROUP);
    producer.setNamesrvAddr(JmsConfig.NAME_SRV);
    producer.start();
    List<Message> messages = new ArrayList<>();
    messages.add(new Message(TOPIC, "batch_tag", "OrderID001", "Hello world 0".getBytes()));
    messages.add(new Message(TOPIC, "batch_tag", "OrderID002", "Hello world 1".getBytes()));
    messages.add(new Message(TOPIC, "batch_tag", "OrderID003", "Hello world 2".getBytes()));
    producer.send(messages);
    producer.shutdown();
  }

  public static void main(String[] args)
      throws MQBrokerException, RemotingException, InterruptedException, MQClientException {
    new BatchProducer();
  }
}
