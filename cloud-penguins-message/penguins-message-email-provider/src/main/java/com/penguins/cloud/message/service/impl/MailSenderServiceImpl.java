package com.penguins.cloud.message.service.impl;

import com.penguins.cloud.message.service.MailSendService;
import org.springframework.stereotype.Service;

/**
 * 邮件发送 Controller
 *
 * @author zhengbing
 * @date 2021/5/7 18:51
 * @email mydreambing@126.com
 */
@Service
public class MailSenderServiceImpl implements MailSendService {

//  @Autowired
//  private MailConfig mailConfig;
//
//  @Autowired
//  private JavaMailSender mailSender;
//
//  @Override
//  public void sendSimpleMail(String sendTo, String title, String content) {
//    SimpleMailMessage message = new SimpleMailMessage();
//    message.setFrom(mailConfig.getFrom());
//    message.setTo(sendTo);
//    message.setSubject(title);
//    message.setText(content);
//    mailSender.send(message);
//  }
//
//  @Override
//  public void sendAttachmentsMail(
//      String sendTo, String title, String content, List<Pair<String, File>> attachments) {}
//
//  @Override
//  public void sendTemplateMail(
//      String sendTo,
//      String title,
//      Map<String, Object> content,
//      List<Pair<String, File>> attachments) {}
}
