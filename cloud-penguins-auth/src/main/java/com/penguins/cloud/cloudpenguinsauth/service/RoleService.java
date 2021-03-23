package com.penguins.cloud.cloudpenguinsauth.service;

import com.penguins.cloud.cloudpenguinsauth.entity.Role;

/**
 * @author zhengbing
 * @date 2021/3/3 13:42
 * @email mydreambing@126.com
 */
public interface RoleService {
    /**
     * 根据ID 查询 Role
     *
     * @param id long
     * @return Role 角色
     */
    Role getById(long id);
}
