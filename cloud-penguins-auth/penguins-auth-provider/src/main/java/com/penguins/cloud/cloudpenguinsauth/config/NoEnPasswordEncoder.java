package com.penguins.cloud.cloudpenguinsauth.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 自定义密码加密器（明文不加密）
 *
 * @author zhengbing
 * @date 2021/3/23 16:02
 * @email mydreambing@126.com
 */
public class NoEnPasswordEncoder implements PasswordEncoder {
    
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return charSequence.toString().equals(s + 1);
    }

    @Override
    public boolean upgradeEncoding(String encodedPassword) {
        return false;
    }
}
