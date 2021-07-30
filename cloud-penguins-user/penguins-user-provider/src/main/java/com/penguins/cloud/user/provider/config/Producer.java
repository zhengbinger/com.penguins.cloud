package com.penguins.cloud.user.provider.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author 郑冰
 * @date 2021/7/27 17:02
 * @email mydreambing@126.com
 * @since jdk8
 **/
@Configuration
public class Producer {

    @Bean
    public Consumer<String> sink1() {
        return message -> {
            System.out.println("******************");
            System.out.println("At Sink1");
            System.out.println("******************");
            System.out.println("Received message " + message);
        };
    }

    @Bean
    public Consumer<String> sink2() {
        return message -> {
            System.out.println("******************");
            System.out.println("At Sink2");
            System.out.println("******************");
            System.out.println("Received message " + message);
        };
    }

    @Bean
    public Supplier<String> source1() {
        return () -> {
            String message = "FromSource1";
            System.out.println("******************");
            System.out.println("From Source1");
            System.out.println("******************");
            System.out.println("Sending value: " + message);
            return message;

        };
    }

    @Bean
    public Supplier<String> source2() {
        return () -> {
            String message = "FromSource2";
            System.out.println("******************");
            System.out.println("From Source2");
            System.out.println("******************");
            System.out.println("Sending value: " + message);
            return message;

        };
    }


}
