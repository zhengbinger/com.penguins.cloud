package com.penguins.cloud.gateway.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.Configuration;

/**
 * 动态路由
 *
 * @author zhengbing
 * @date 2021/1/26 00:09
 * @email mydreambing@126.com
 */
@Configuration
public class DynamicRoutingConfiguration implements ApplicationEventPublisherAware {

    private final Logger logger = LoggerFactory.getLogger(DynamicRoutingConfiguration.class);
    

    @Autowired
    private RouteDefinitionWriter routeDefinitionWriter;

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {

    }
}
