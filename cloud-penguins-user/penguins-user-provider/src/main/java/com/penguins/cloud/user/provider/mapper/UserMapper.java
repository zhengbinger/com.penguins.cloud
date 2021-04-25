package com.penguins.cloud.user.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.penguins.cloud.user.provider.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhengbing
 * @date 2021/4/25 16:00
 * @email mydreambing@126.com
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {}
