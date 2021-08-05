package com.penguins.cloud.message.sms;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.teaopenapi.models.Config;
import com.penguins.cloud.message.constants.SmsConstants;

import java.util.Map;

/**
 * @author zhengbing
 * @date 2021/5/7 09:44
 * @email mydreambing@126.com
 */
public class AliyunSmsSender implements SmsSender {

  /**
   * 使用AK&SK初始化账号Client
   *
   * @param accessKeyId String
   * @param accessKeySecret String
   * @return Client
   * @throws Exception
   */
  public static Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
    Config config =
        new Config()
            // 您的AccessKey ID
            .setAccessKeyId(accessKeyId)
            // 您的AccessKey Secret
            .setAccessKeySecret(accessKeySecret);
    // 访问的域名
    config.endpoint = SmsConstants.ALIYUN_ENDPOINT;
    return new Client(config);
  }

  public static void main(String[] args) throws Exception {
    java.util.List<String> args1 = java.util.Arrays.asList(args);
    Client client =
        AliyunSmsSender.createClient("W1rH2R0wNNR4fpdy", "LcsXozPf0oNvbjEXzXeAXk1gNGhNOj");
    SendSmsRequest sendSmsRequest = new SendSmsRequest();
    sendSmsRequest.setPhoneNumbers("15918713381");
    sendSmsRequest.setSignName("郑冰");
    sendSmsRequest.setTemplateCode("SMS_42685022");
    sendSmsRequest.setTemplateParam("{\"name\":\"test\",\"day\":5}");
    // 复制代码运行请自行打印 API 的返回值
    client.sendSms(sendSmsRequest);
  }

  @Override
  public void send(Map<String, Object> params) {}
}
