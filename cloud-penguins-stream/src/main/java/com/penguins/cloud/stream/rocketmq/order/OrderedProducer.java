package com.penguins.cloud.stream.rocketmq.order;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author zhengbing
 * @date 2021/4/18 23:53
 * @email mydreambing@126.com
 */
public class OrderedProducer {

  /**
   * @throws MQClientException
   * @throws MQBrokerException
   * @throws RemotingException
   * @throws InterruptedException
   */
  public void sendOrderedMessage()
      throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
    // 通过一个唯一的生产者组名，实例化一个 DefaultMQProducer
    DefaultMQProducer producer = new DefaultMQProducer("ordered_group");
    // 配置NameServer 地址端口
    producer.setNamesrvAddr("120.25.218.127:9876");
    // 运行 producer 实例
    producer.start();
    String[] tags = new String[] {"orderTagA", "orderTagB", "orderTagC", "orderTagD", "orderTagE"};
    for (int i = 0; i < 100; i++) {

      int orderId = i % 10;
      Message msg =
          new Message(
              "ordered_topic",
              tags[i % tags.length],
              ("Hello RocketMQ" + i).getBytes(StandardCharsets.UTF_8));
      SendResult sendResult =
          producer.send(
              msg,
              new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                  Integer id = (Integer) o;
                  int index = id % list.size();
                  return list.get(index);
                }
              },
              orderId);
      System.out.printf("%s%n", sendResult);
    }
    Thread.sleep(5000);
    // 关闭生产者，当生产者不再被使用时
    producer.shutdown();
  }

  public static void main(String[] args)
      throws MQBrokerException, RemotingException, InterruptedException, MQClientException {
    new OrderedProducer().sendOrderedMessage();
  }
}
