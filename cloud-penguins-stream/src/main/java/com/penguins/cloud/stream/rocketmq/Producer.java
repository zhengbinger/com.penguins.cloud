package com.penguins.cloud.stream.rocketmq;

import com.penguins.cloud.stream.rocketmq.config.JmsConfig;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.stereotype.Component;

/**
 * @author zhengbing
 * @date 2021/4/15 15:48
 * @email mydreambing@126.com
 */
@Component
public class Producer {

  private String producerGroup = "test_producer";

  private DefaultMQProducer producer;

  public Producer() {
    producer = new DefaultMQProducer(producerGroup);
    // 不开启vip通道 开通口端口会减2
    producer.setVipChannelEnabled(false);
    // 绑定name server
    producer.setNamesrvAddr(JmsConfig.NAME_SRV);
    start();
  }

  private void start() {
    try {
      this.producer.start();
    } catch (MQClientException e) {
      e.printStackTrace();
    }
  }

  public DefaultMQProducer getProducer() {
    return this.producer;
  }
  /** 一般在应用上下文，使用上下文监听器，进行关闭 */
  public void shutdown() {
    this.producer.shutdown();
  }
}
