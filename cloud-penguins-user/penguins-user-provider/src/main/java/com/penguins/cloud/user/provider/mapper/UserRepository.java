package com.penguins.cloud.user.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.penguins.cloud.user.api.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * UserRepository
 *
 * @author zhengbing
 * @date 2021/1/20
 * @email mydreambing@126.com
 */
@Mapper
public interface UserRepository extends BaseMapper<User> {

  @Select("select id,username,password from  penguins_user where username=#{username}")
  User getUserByUsername(String username);

  @Select(
      "select role_id from penguins_user_role where user_id = (select id from penguins_user where  username=#{username})")
  long getRoleIdByUserName(String username);
}
