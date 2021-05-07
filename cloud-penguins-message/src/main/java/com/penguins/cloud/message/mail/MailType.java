package com.penguins.cloud.message.mail;

/**
 * 邮件类型枚举类
 *
 * @author zhengbing
 * @date 2021/4/19 19:36
 * @email mydreambing@126.com
 */
public enum MailType {
  /** 基础文本邮件 */
  text("文本邮件"),
  /** 附件邮件 */
  attachment("附件邮件"),
  /** 模板邮件 */
  template("模板邮件");

  private String name;

  MailType(String name) {
    this.name = name;
  }
}
