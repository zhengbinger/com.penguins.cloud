package com.penguins.cloud.message.controller;

import com.penguins.cloud.commons.web.RspResult;
import com.penguins.cloud.message.service.MailSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengbing
 * @date 2021/5/7 10:51
 * @email mydreambing@126.com
 */
@RestController
@RequestMapping("mail")
public class MailController {

  @Autowired private MailSendService mailSendService;

  /** 测试邮件发送 */
  @RequestMapping(value = "send/simple", method = RequestMethod.GET)
  public @ResponseBody RspResult<Boolean> sendSimple() throws Exception {
    String sendTo = "1375005587@qq.com";
    String title = "测试邮件标题";
    String content = "测试邮件内容";
    mailSendService.sendSimpleMail(sendTo, title, content);
    return RspResult.success();
  }
}
