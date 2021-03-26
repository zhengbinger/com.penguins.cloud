package com.penguins.cloud.cloudpenguinsauth.config;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义 UserDetailsManager
 * 代理 {@link org.springframework.security.provisioning.UserDetailsManager} 所有功能
 *
 * @author zhengbing
 * @date 2021/3/26 01:20
 * @email mydreambing@126.com
 */
public class CustomUserDetailsRepository implements UserRepository {

    private Map<String, UserDetails> users = new HashMap<>();

    public void createUser(UserDetails user) {
        users.putIfAbsent(user.getUsername(), user);
    }

    public void updateUser(UserDetails user) {
        users.put(user.getUsername(), user);
    }

    public void deleteUser(String username) {
        users.remove(username);
    }

    public void changePassword(String oldPassword, String newPassword) {
        Authentication currentUser = SecurityContextHolder.getContext()
                .getAuthentication();

        if (currentUser == null) {
            // This would indicate bad coding somewhere
            throw new AccessDeniedException(
                    "Can't change password as no Authentication object found in context "
                            + "for current user.");
        }

        String username = currentUser.getName();

        UserDetails user = users.get(username);


        if (user == null) {
            throw new IllegalStateException("Current user doesn't exist in database.");
        }

        // todo copy InMemoryUserDetailsManager  自行实现具体的更新密码逻辑
    }

    public boolean userExists(String username) {
        return users.containsKey(username);
    }


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.get(username);
    }

}
