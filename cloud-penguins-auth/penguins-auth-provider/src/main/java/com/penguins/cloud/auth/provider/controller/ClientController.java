package com.penguins.cloud.auth.provider.controller;

import com.penguins.cloud.auth.api.entity.OauthClientDetails;
import com.penguins.cloud.auth.api.service.OauthClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 郑冰
 * @date 2021/7/18 16:04
 * @email mydreambing@126.com
 * @since jdk8
 **/
@RestController(value = "auth/clients")
public class ClientController {

    @Autowired
    private OauthClientDetailsService clientDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 客户端接入合作
     *
     * @param client Clientdetails
     */
    @PostMapping
    public void clientCoopration(@RequestBody OauthClientDetails client) {
        client.setClientSecret(passwordEncoder.encode(client.getClientSecret()));
        clientDetailsService.insert(client);
    }

    /**
     * 解除合作
     *
     * @param clientId String
     */
    public void dessolveCoopration(String clientId) {
        System.out.println("解除合作");
    }

}
