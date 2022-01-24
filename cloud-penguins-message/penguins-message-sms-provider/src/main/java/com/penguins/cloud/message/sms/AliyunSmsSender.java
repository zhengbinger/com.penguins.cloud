package com.penguins.cloud.message.sms;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.teaopenapi.models.Config;
import com.penguins.cloud.message.constants.SmsConstants;
import com.penguins.cloud.message.sms.config.AliyunConfigureProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author zhengbing
 * @date 2021/5/7 09:44
 * @email mydreambing@126.com
 */
@Component
public class AliyunSmsSender implements SmsSender {

    private Logger log = LoggerFactory.getLogger(AliyunSmsSender.class);
  
    /**
     * 使用AK&SK初始化账号Client
     *
     * @param accessKeyId     String
     * @param accessKeySecret String
     * @return Client
     */
    public static Client createClient(String accessKeyId, String accessKeySecret) {
        Config config =
                new Config()
                        // 您的AccessKey ID
                        .setAccessKeyId(accessKeyId)
                        // 您的AccessKey Secret
                        .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = SmsConstants.ALIYUN_ENDPOINT;
        try {
            return new Client(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Autowired
    private AliyunConfigureProperties aliyunConfigureProperties;

    @Override
    @ConditionalOnBean(AliyunConfigureProperties.class)
    public void send(Map<String, Object> params) throws Exception {
        log.info("发送短信到XXX");
        Client client =
                AliyunSmsSender.createClient(aliyunConfigureProperties.getAccessKeyId(), aliyunConfigureProperties.getAccessKeySecret());
        SendSmsRequest sendSmsRequest = new SendSmsRequest();
        sendSmsRequest.setPhoneNumbers("15918713381");
        sendSmsRequest.setSignName("郑冰");
        sendSmsRequest.setTemplateCode("SMS_42685022");
        sendSmsRequest.setTemplateParam("{\"name\":\"test\",\"day\":5}");
        // 复制代码运行请自行打印 API 的返回值
        assert client != null;
        SendSmsResponse smsResponse = client.sendSms(sendSmsRequest);
        System.out.println(smsResponse.getBody().message);
    }

}
