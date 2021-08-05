package com.penguins.cloud.message.sms.config;

import java.util.List;
import java.util.Map;

/**
 * @author zhengbing
 * @date 2021/5/7 09:41
 * @email mydreambing@126.com
 */
public class AliSmsBean {

  /** 短信接收人 */
  private List<String> receivers;
  /** 短信动态参数 */
  private Map<String, Object> params;
  /** 短信模板编码 */
  private String templateCode;
}
