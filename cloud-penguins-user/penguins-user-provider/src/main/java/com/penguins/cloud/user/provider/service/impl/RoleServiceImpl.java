package com.penguins.cloud.user.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.penguins.cloud.user.api.entity.Role;
import com.penguins.cloud.user.provider.mapper.RoleRepository;
import com.penguins.cloud.user.provider.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author zhengbing
 * @date 2021/3/3 13:42
 * @email mydreambing@126.com
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleRepository, Role> implements RoleService {

  @Autowired private RoleRepository roleRepository;

  @Override
  @Cacheable(cacheNames = {"roleid"})
  public Role getById(long id) {
    return roleRepository.getById(id);
  }
}
