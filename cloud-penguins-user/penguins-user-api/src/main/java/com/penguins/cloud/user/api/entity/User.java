package com.penguins.cloud.user.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户实体类
 *
 * @author zhengbing
 * @date 2021/4/24 18:46
 * @email mydreambing@126.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private String username;
  private String realName;
  private String email;
}
