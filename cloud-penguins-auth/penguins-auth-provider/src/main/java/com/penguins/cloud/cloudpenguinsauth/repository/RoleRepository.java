package com.penguins.cloud.cloudpenguinsauth.repository;

import com.penguins.cloud.cloudpenguinsauth.entity.RoleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author zhengbing
 * @date 2021/3/3 11:25
 * @email mydreambing@126.com
 */
@Mapper
public interface RoleRepository {

  @Select("select id,role_code,role_name from penguins_role  where id = #{id}")
  RoleInfo getById(long id);
}
