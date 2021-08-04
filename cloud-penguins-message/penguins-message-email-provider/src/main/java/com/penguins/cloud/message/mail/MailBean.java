package com.penguins.cloud.message.mail;

import java.util.List;

/**
 * @author zhengbing
 * @date 2021/4/19 19:39
 * @email mydreambing@126.com
 */
public class MailBean {

  /** 接收人 */
  private List<String> to;

  /** 发送人 */
  private String from;

  /** 抄送人地址 */
  private List<String> cc;

  /** 邮件内容 */
  private String content;
}
