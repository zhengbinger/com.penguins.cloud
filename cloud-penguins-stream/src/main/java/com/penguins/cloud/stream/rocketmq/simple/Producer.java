package com.penguins.cloud.stream.rocketmq.simple;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 生产者
 *
 * @author zhengbing
 * @date 2021/4/16 14:56
 * @email mydreambing@126.com
 */
public class Producer {

  /**
   * 可靠同步消息发送(默认方式)
   *
   * @throws MQClientException
   * @throws MQBrokerException
   * @throws RemotingException
   * @throws InterruptedException
   */
  public void sendSyncMessage()
      throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
    // 通过一个唯一的生产者组名，实例化一个 DefaultMQProducer
    DefaultMQProducer producer = new DefaultMQProducer("sync_group");
    // 配置NameServer 地址端口
    producer.setNamesrvAddr("120.25.218.127:9876");
    // 运行 producer 实例
    producer.start();

    for (int i = 0; i < 100; i++) {

      // 创建一个消息实例 Topic Tag 消息内容
      Message msg =
          new Message(
              "sync_topic", "sync_tag", ("Hello RocketMQ " + i).getBytes(StandardCharsets.UTF_8));
      // 通过传递消息到 broker 来发送消息，并获取发送结果
      SendResult sendResult = producer.send(msg);
      // 打印发送结果
      System.out.printf("%s%n", sendResult);
    }
    // 关闭生产者，当生产者不再被使用时
    producer.shutdown();
  }

  /**
   * 可靠异步消息发送
   *
   * @throws MQClientException
   * @throws MQBrokerException
   * @throws RemotingException
   * @throws InterruptedException
   */
  public void sendAsyncMessage()
      throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
    // 通过一个唯一的生产者组名，实例化一个 DefaultMQProducer
    DefaultMQProducer producer = new DefaultMQProducer("async_group");
    // 配置NameServer 地址端口
    producer.setNamesrvAddr("120.25.218.127:9876");
    // 运行 producer 实例
    producer.start();
    // 设置发送异步消息失败的情况下重试次数
    producer.setRetryTimesWhenSendAsyncFailed(0);

    int messageCount = 100;
    final CountDownLatch countDownLatch = new CountDownLatch(messageCount);
    for (int i = 0; i < messageCount; i++) {
      // 创建一个消息实例 Topic Tag 消息内容
      Message msg =
          new Message(
              "async_topic",
              "async_tag",
              "async_keys110",
              ("Hello RocketMQ " + i).getBytes(StandardCharsets.UTF_8));
      final int index = i;
      // 通过传递消息到 broker 来发送消息，并获取发送结果

      producer.send(
          msg,
          new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
              countDownLatch.countDown();
              System.out.printf("%-10d OK %s %n", index, sendResult.getMsgId());
            }

            @Override
            public void onException(Throwable e) {
              countDownLatch.countDown();
              System.out.printf("%-10d Fail %s %n", index, e);
              e.printStackTrace();
            }
          });
    }
    countDownLatch.await(5, TimeUnit.SECONDS);
    // 关闭生产者，当生产者不再被使用时
    producer.shutdown();
  }

  /**
   * @throws MQClientException
   * @throws MQBrokerException
   * @throws RemotingException
   * @throws InterruptedException
   */
  public void sendOneWayMessage()
      throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
    // 通过一个唯一的生产者组名，实例化一个 DefaultMQProducer
    DefaultMQProducer producer = new DefaultMQProducer("async_group");
    // 配置NameServer 地址端口
    producer.setNamesrvAddr("120.25.218.127:9876");
    // 运行 producer 实例
    producer.start();

    for (int i = 0; i < 100; i++) {
      Message msg =
          new Message(
              "one_way_topic",
              "one_way_tag",
              ("Hello RocketMQ" + i).getBytes(StandardCharsets.UTF_8));
      producer.sendOneway(msg);
    }
    Thread.sleep(5000);
    // 关闭生产者，当生产者不再被使用时
    producer.shutdown();
  }

  public static void main(String[] args) {
    try {
      Producer producer = new Producer();
      producer.sendSyncMessage();
      producer.sendAsyncMessage();
      producer.sendOneWayMessage();
    } catch (MQClientException | MQBrokerException | RemotingException | InterruptedException e) {
      e.printStackTrace();
    }
  }
}
