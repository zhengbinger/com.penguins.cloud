package com.penguins.cloud.cloudpenguinsauth.service.impl;

import com.penguins.cloud.cloudpenguinsauth.entity.Role;
import com.penguins.cloud.cloudpenguinsauth.repository.RoleMapper;
import com.penguins.cloud.cloudpenguinsauth.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhengbing
 * @date 2021/3/3 13:42
 * @email mydreambing@126.com
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role getById(long id) {
        return roleMapper.getById(id);
    }
}
