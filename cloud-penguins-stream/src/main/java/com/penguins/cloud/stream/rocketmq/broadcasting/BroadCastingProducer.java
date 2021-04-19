package com.penguins.cloud.stream.rocketmq.broadcasting;

import com.penguins.cloud.stream.rocketmq.config.JmsConfig;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;

/**
 * @author zhengbing
 * @date 2021/4/19 15:04
 * @email mydreambing@126.com
 */
public class BroadCastingProducer {
  private DefaultMQProducer producer = null;
  private static final String GROUP = "broad_casting_group";
  private static final String TOPIC = "broad_casting_topic";
  private static final String TAG = "broad_casting_tag";
  private static final String KEYS = "broad_casting_keys";

  public BroadCastingProducer()
      throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
    producer = new DefaultMQProducer(GROUP);
    producer.setNamesrvAddr(JmsConfig.NAME_SRV);
    producer.start();
    for (int i = 0; i < 10; i++) {
      Message msg = new Message(TOPIC, TAG, KEYS, "Hello world".getBytes(StandardCharsets.UTF_8));
      SendResult sendResult = producer.send(msg);
      System.out.printf("%s%n", sendResult);
    }
    producer.shutdown();
  }

  public static void main(String[] args)
      throws MQBrokerException, RemotingException, InterruptedException, MQClientException {
    new BroadCastingProducer();
  }
}
