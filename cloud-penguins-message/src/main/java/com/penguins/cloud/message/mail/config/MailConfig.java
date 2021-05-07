package com.penguins.cloud.message.mail.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhengbing
 * @date 2021/5/7 16:39
 * @email mydreambing@126.com
 */
@Configuration
public class MailConfig {

  @Value("${spring.mail.username}")
  private String from;

  public String getFrom() {
    return from;
  }

  public MailConfig setFrom(String from) {
    this.from = from;
    return this;
  }
}
