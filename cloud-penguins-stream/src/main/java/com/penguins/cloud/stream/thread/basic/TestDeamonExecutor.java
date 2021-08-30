package com.penguins.cloud.stream.thread.basic;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 郑冰
 * @date 2021/8/27 17:10
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class TestDeamonExecutor extends ThreadPoolExecutor {

    public TestDeamonExecutor() {
        super(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                new TestDeamonFactory());
    }
}
