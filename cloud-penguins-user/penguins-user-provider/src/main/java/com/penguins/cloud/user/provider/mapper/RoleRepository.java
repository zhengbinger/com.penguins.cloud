package com.penguins.cloud.user.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.penguins.cloud.user.api.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author zhengbing
 * @date 2021/3/3 11:25
 * @email mydreambing@126.com
 */
@Mapper
public interface RoleRepository extends BaseMapper<Role> {

  /**
   * 根据ID查询
   *
   * @param id long
   * @return Role
   */
  @Select("select id,role_code,role_name from penguins_role  where id = #{id}")
  Role getById(long id);
}
