package com.penguins.cloud.stream.rocketmq;

import com.penguins.cloud.stream.rocketmq.config.JmsConfig;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengbing
 * @date 2021/4/15 15:56
 * @email mydreambing@126.com
 */
@RestController
public class Controller {

  Logger log = LoggerFactory.getLogger(Controller.class);

  @Autowired private Producer producer;

  private List<String> mesList;

  /** 初始化消息 */
  public Controller() {
    mesList = new ArrayList<>();
    mesList.add("小小");
    mesList.add("爸爸");
    mesList.add("妈妈");
    mesList.add("爷爷");
    mesList.add("奶奶");
  }

  @RequestMapping("/text/rocketmq")
  public Object callback() throws Exception {
    // 总共发送五次消息
    for (String s : mesList) {
      // 创建生产信息
      Message message = new Message(JmsConfig.TOPIC, "testtag", ("小小一家人的称谓:" + s).getBytes());
      // 发送
      SendResult sendResult = producer.getProducer().send(message);
      log.info("输出生产者信息={}", sendResult);
    }
    return "成功";
  }
}
