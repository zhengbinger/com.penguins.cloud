package com.penguins.cloud.message.mail.config;

import lombok.Data;

/**
 * 邮件服务配置
 *
 * @author zhengbing
 * @date 2021/4/19 19:44
 * @email mydreambing@126.com
 */
@Data
public class MailConfigBean {

  /** 邮件服务端地址 */
  private String host;

  /** 邮件服务端端口 */
  private int port;

  /** 邮件服务端，发送人用户名 */
  private String usernmae;

  /** 邮件服务端，发送人用户密码 */
  private String password;
}
