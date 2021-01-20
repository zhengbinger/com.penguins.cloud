package com.penguins.cloud.cloudpenguinsauth.repository;

import com.penguins.cloud.cloudpenguinsauth.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author zhengbing
 * @date 2021/1/20
 * @email mydreambing@126.com
 */
@Mapper
public interface UserInfoMapper {

    @Select("select id,username,password from  penguins_user where username=#{username}")
    UserInfo getUserByUsername(String username);
}
