// package com.penguins.cloud.cloudpenguinsauth.config;
//
// import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
// import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.core.authority.AuthorityUtils;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.provisioning.UserDetailsManager;
//
/// **
// * 自定义实现 UserDetailsManager
// *
// * @author zhengbing
// * @date 2021/3/26 01:28
// * @email mydreambing@126.com
// */
// @Configuration
// @ConditionalOnMissingBean(UserDetailsService.class)
// public class CustomUserDetailsManagerConfig {
//
//  @Bean
//  public UserDetailsManager userDetailsManager(UserInfoRepository userRepository) {
//
//    return new UserDetailsManager() {
//      @Override
//      public void createUser(UserDetails user) {
//        userRepository.insert(user);
//      }
//
//      @Override
//      public void updateUser(UserDetails user) {
//        userRepository.updateById(user);
//      }
//
//      @Override
//      public void deleteUser(String username) {
//        QueryWrapper<UserDetails> wrapper = new QueryWrapper<UserDetails>();
//        wrapper.eq("username", username);
//        userRepository.delete(wrapper);
//      }
//
//      @Override
//      public void changePassword(String oldPassword, String newPassword) {}
//
//      @Override
//      public boolean userExists(String username) {
//        return false;
//      }
//
//      @Override
//      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userRepository.getUserByUsername(username);
//      }
//    };
//  }
//
//  @ConditionalOnMissingBean(value = UserRepository.class)
//  @Bean
//  public CustomUserDetailsRepository customUserDetailsManager() {
//    CustomUserDetailsRepository customUserDetailsManager = new CustomUserDetailsRepository();
//    UserDetails zhengbing =
//        User.withUsername("zhengbing")
//            .password("{noop}12345")
//            .authorities(AuthorityUtils.NO_AUTHORITIES)
//            .build();
//    customUserDetailsManager.createUser(zhengbing);
//    return customUserDetailsManager;
//  }
// }
