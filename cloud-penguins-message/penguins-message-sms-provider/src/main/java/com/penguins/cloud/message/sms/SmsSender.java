package com.penguins.cloud.message.sms;

import java.util.Map;

/**
 * 短息发送接口
 *
 * @author zhengbing
 * @date 2021/5/7 09:38
 * @email mydreambing@126.com
 */
public interface SmsSender {

  /**
   * 短信发送
   *
   * @param params 发送短信所需参数
   */
  void send(Map<String, Object> params) throws Exception;
}
