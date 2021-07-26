package com.penguins.cloud.user.provider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.penguins.cloud.user.api.entity.Permission;

import java.util.Collection;

/**
 * 权限服务接口
 *
 * @author zhengbing
 * @date 2021/4/27 16:57
 * @email mydreambing@126.com
 */
public interface PermissionService extends IService<Permission> {

    /**
     * 根据用户名，获取用户的所有权限
     *
     * @param username String 用户名
     * @return Collection<Permission> 权限集
     */
    Collection<Permission> getPermissionsByUsername(String username);
}
