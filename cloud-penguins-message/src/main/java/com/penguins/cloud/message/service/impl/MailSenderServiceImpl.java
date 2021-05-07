package com.penguins.cloud.message.service.impl;

import com.penguins.cloud.message.mail.config.MailConfig;
import com.penguins.cloud.message.service.MailSendService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 邮件发送 Controller
 *
 * @author zhengbing
 * @date 2021/5/7 18:51
 * @email mydreambing@126.com
 */
@Service
public class MailSenderServiceImpl implements MailSendService {

  @Autowired private MailConfig mailConfig;
  @Autowired private JavaMailSender mailSender;

  @Override
  public void sendSimpleMail(String sendTo, String title, String content) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom(mailConfig.getFrom());
    message.setTo(sendTo);
    message.setSubject(title);
    message.setText(content);
    mailSender.send(message);
  }

  @Override
  public void sendAttachmentsMail(
      String sendTo, String title, String content, List<Pair<String, File>> attachments) {}

  @Override
  public void sendTemplateMail(
      String sendTo,
      String title,
      Map<String, Object> content,
      List<Pair<String, File>> attachments) {}
}
