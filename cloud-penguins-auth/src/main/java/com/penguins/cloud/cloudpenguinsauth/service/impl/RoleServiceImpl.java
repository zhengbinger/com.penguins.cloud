package com.penguins.cloud.cloudpenguinsauth.service.impl;

import com.penguins.cloud.cloudpenguinsauth.entity.Role;
import com.penguins.cloud.cloudpenguinsauth.repository.RoleRepository;
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
    private RoleRepository roleRepository;

    @Override
    public Role getById(long id) {
        return roleRepository.getById(id);
    }
}
