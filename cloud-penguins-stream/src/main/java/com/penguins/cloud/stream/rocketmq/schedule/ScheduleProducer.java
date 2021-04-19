package com.penguins.cloud.stream.rocketmq.schedule;

import com.penguins.cloud.stream.rocketmq.config.JmsConfig;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.nio.charset.StandardCharsets;

/**
 * 定时消息 - 生产者
 *
 * @author zhengbing
 * @date 2021/4/19 16:41
 * @email mydreambing@126.com
 */
public class ScheduleProducer {

  private static final String GROUP = "schedule_group";
  private static final String TOPIC = "schedule_topic";
  private DefaultMQProducer producer = null;

  public ScheduleProducer()
      throws MQClientException, MQBrokerException, RemotingException, InterruptedException {

    producer = new DefaultMQProducer(GROUP);
    producer.setNamesrvAddr(JmsConfig.NAME_SRV);
    producer.start();

    for (int i = 0; i < 10; i++) {
      Message msg =
          new Message(TOPIC, ("Hello scheduled message " + i).getBytes(StandardCharsets.UTF_8));
      msg.setDelayTimeLevel(3);
      SendResult result = producer.send(msg);
      System.out.println(result + " [" + System.currentTimeMillis() + "]");
    }
    producer.shutdown();
  }

  public static void main(String[] args)
      throws MQBrokerException, RemotingException, InterruptedException, MQClientException {
    new ScheduleProducer();
  }
}
