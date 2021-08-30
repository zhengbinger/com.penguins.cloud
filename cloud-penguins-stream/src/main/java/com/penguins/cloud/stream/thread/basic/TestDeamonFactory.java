package com.penguins.cloud.stream.thread.basic;

import java.util.concurrent.ThreadFactory;

/**
 * @author 郑冰
 * @date 2021/8/27 16:57
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class TestDeamonFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
