package com.penguins.cloud.message.mail.config;

/**
 * 邮件服务配置
 *
 * @author zhengbing
 * @date 2021/4/19 19:44
 * @email mydreambing@126.com
 */
public class MailConfigBean {

  /** 邮件服务端地址 */
  private String host;

  /** 邮件服务端端口 */
  private int port;

  /** 邮件服务端，发送人用户名 */
  private String usernmae;

  /** 邮件服务端，发送人用户密码 */
  private String password;

  public String getHost() {
    return host;
  }

  public MailConfigBean setHost(String host) {
    this.host = host;
    return this;
  }

  public int getPort() {
    return port;
  }

  public MailConfigBean setPort(int port) {
    this.port = port;
    return this;
  }

  public String getUsernmae() {
    return usernmae;
  }

  public MailConfigBean setUsernmae(String usernmae) {
    this.usernmae = usernmae;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public MailConfigBean setPassword(String password) {
    this.password = password;
    return this;
  }
}
