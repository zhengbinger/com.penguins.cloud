package com.penguins.cloud.stream.rocketmq.order;

import com.penguins.cloud.stream.rocketmq.config.JmsConfig;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengbing
 * @date 2021/4/18 23:53
 * @email mydreambing@126.com
 */
@RestController
public class OrderedProducer {

  private static List<ProductOrder> orderList = null;

  /** 模拟数据 */
  static {
    orderList = new ArrayList<>();
    orderList.add(new ProductOrder("XXX001", "订单创建"));
    orderList.add(new ProductOrder("XXX001", "订单付款"));
    orderList.add(new ProductOrder("XXX001", "订单完成"));
    orderList.add(new ProductOrder("XXX002", "订单创建"));
    orderList.add(new ProductOrder("XXX002", "订单付款"));
    orderList.add(new ProductOrder("XXX002", "订单完成"));
    orderList.add(new ProductOrder("XXX003", "订单创建"));
    orderList.add(new ProductOrder("XXX003", "订单付款"));
    orderList.add(new ProductOrder("XXX003", "订单完成"));
  }

  /**
   * @throws MQClientException
   * @throws MQBrokerException
   * @throws RemotingException
   * @throws InterruptedException
   */
  @GetMapping
  public void sendOrderedMessage()
      throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
    // 通过一个唯一的生产者组名，实例化一个 DefaultMQProducer
    DefaultMQProducer producer = new DefaultMQProducer("ordered_group");
    // 配置NameServer 地址端口
    producer.setNamesrvAddr(JmsConfig.NAME_SRV);
    // 运行 producer 实例
    producer.start();
    for (ProductOrder order : orderList) {

      Message msg =
          new Message(
              "ordered_topic",
              order.getOrderId(),
              (order.toString()).getBytes(StandardCharsets.UTF_8));
      SendResult sendResult =
          producer.send(
              msg,
              new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object arg) {
                  // 3、arg的值其实就是下面传入 orderId
                  String orderid = (String) arg;
                  // 4、因为订单是String类型，所以通过hashCode转成int类型
                  int hashCode = orderid.hashCode();
                  // 5、因为hashCode可能为负数 所以取绝对值
                  hashCode = Math.abs(hashCode);
                  // 6、保证同一个订单号 一定分配在同一个queue上
                  long index = hashCode % list.size();
                  return list.get((int) index);
                }
              },
              order.getOrderId(),
              50000);
      System.out.printf(
          "Product：发送状态=%s, 存储queue=%s ,orderid=%s, type=%s\n",
          sendResult.getSendStatus(),
          sendResult.getMessageQueue().getQueueId(),
          order.getOrderId(),
          order.getType());
    }
    // 关闭生产者，当生产者不再被使用时
    producer.shutdown();
  }

  public static void main(String[] args)
      throws MQBrokerException, RemotingException, InterruptedException, MQClientException {
    new OrderedProducer().sendOrderedMessage();
  }
}
