package com.penguins.cloud.user.provider.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.penguins.cloud.user.api.entity.Permission;
import com.penguins.cloud.user.provider.mapper.PermissionRepository;
import com.penguins.cloud.user.provider.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author zhengbing
 * @date 2021/3/3 13:42
 * @email mydreambing@126.com
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionRepository, Permission>
        implements PermissionService {

    @Override
    public Collection<Permission> getPermissionsByUsername(String username) {
        QueryWrapper<Permission> query = new QueryWrapper<>();
        query.eq("role_id", username);
        return this.list(query);
    }
}
