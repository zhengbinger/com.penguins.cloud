package com.penguins.cloud.user.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhengbing
 * @date 2021/4/25 17:21
 * @email mydreambing@126.com
 */
@FeignClient("penguins-files-provider")
public interface FileRecordService {
  /**
   * 通过 OpenFeign 远程调用 penguins-files-provider 服务的接口
   *
   * @return String
   */
  @GetMapping("files/get")
  public String get();
}
