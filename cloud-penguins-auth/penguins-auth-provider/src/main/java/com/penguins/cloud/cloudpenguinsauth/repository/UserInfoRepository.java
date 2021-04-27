package com.penguins.cloud.cloudpenguinsauth.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.penguins.cloud.cloudpenguinsauth.config.UserRepository;
import com.penguins.cloud.cloudpenguinsauth.entity.UserInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

/**
 * UserRepository
 *
 * @author zhengbing
 * @date 2021/1/20
 * @email mydreambing@126.com
 */
@Repository
public interface UserInfoRepository extends BaseMapper<UserDetails>, UserRepository {

  @Select("select id,username,password from  penguins_user where username=#{username}")
  UserInfo getUserByUsername(String username);

  @Select(
      "select role_id from penguins_user_role where user_id = (select id from penguins_user where  username=#{username})")
  long getRoleIdByUserName(String username);
}
