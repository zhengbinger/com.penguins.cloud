package com.penguins.cloud.auth.provider.config;

import com.penguins.cloud.auth.provider.entity.UserInfo;
import com.penguins.cloud.web.RspResult;
import com.penguins.cloud.user.api.entity.Role;
import com.penguins.cloud.user.api.entity.User;
import com.penguins.cloud.user.client.service.RoleFeignService;
import com.penguins.cloud.user.client.service.UserFeignService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * 用户认证业务逻辑
 *
 * @author zhengbing
 * @date 2021/3/23 17:03
 * @email mydreambing@126.com
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

  private final Log log = LogFactory.getLog(UserDetailsServiceImpl.class);

  @Autowired
  private UserFeignService userFeignService;
  @Autowired
  private RoleFeignService roleFeignService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    log.info("load username is:" + username);
    RspResult<User> userInfo = userFeignService.loadByUsername(username);
    User user = userInfo.getData();
    if (user == null) {
      throw new UsernameNotFoundException("user " + username + "is not found");
    }
    RspResult<Long> roleId = userFeignService.getRoleIdByUsername(username);
    RspResult<Role> roleInfo = roleFeignService.getRoleById(roleId.getData());

    return new UserInfo(username, user.getPassword(), Collections.singleton(roleInfo.getData()));
  }
}
