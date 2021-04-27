package com.penguins.cloud.user.provider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.penguins.cloud.user.api.entity.Role;

/**
 * @author zhengbing
 * @date 2021/4/27 16:57
 * @email mydreambing@126.com
 */
public interface RoleService extends IService<Role> {

  /**
   * 根据ID 查询 RoleInfo
   *
   * @param id long
   * @return RoleInfo 角色
   */
  Role getById(long id);
}
