package com.penguins.cloud.files.provider.controller;

import com.penguins.cloud.files.provider.entity.FileRecord;
import com.penguins.cloud.files.provider.service.FileRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengbing
 * @date 2021/4/25 16:07
 * @email mydreambing@126.com
 */
@RestController
@RequestMapping("file/record")
public class FileRecordController {

  @Autowired private FileRecordService fileRecordService;

  @GetMapping("get")
  public String get() throws InterruptedException {
    FileRecord file = fileRecordService.getById(1);
    if (null != file) {
      return file.toString();
    }
    return null;
  }
}
