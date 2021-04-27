package com.penguins.cloud.cloudpenguinsauth.service;

import com.penguins.cloud.cloudpenguinsauth.entity.RoleInfo;

/**
 * @author zhengbing
 * @date 2021/3/3 13:42
 * @email mydreambing@126.com
 */
public interface RoleService {
  /**
   * 根据ID 查询 RoleInfo
   *
   * @param id long
   * @return RoleInfo 角色
   */
  RoleInfo getById(long id);
}
