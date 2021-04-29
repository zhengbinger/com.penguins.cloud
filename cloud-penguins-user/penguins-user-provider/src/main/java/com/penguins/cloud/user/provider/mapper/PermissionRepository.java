package com.penguins.cloud.user.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.penguins.cloud.user.api.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhengbing
 * @date 2021/4/29 17:26
 * @email mydreambing@126.com
 */
@Mapper
public interface PermissionRepository extends BaseMapper<Permission> {}
