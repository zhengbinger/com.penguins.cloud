package com.penguins.cloud.user.client.service.impl;

import com.penguins.cloud.user.client.service.FileRecordService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * @author zhengbing
 * @date 2021/4/26 14:31
 * @email mydreambing@126.com
 */
@Component
public class FileRecordServiceImpl implements FileRecordService {

  private final Log log = LogFactory.getLog(FileRecordServiceImpl.class);

  @Override
  public String get() {
    log.error("files provider's get interface error");
    return null;
  }
}
