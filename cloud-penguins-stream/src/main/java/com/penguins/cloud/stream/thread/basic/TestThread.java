package com.penguins.cloud.stream.thread.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 郑冰
 * @date 2021/8/27 14:13
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class TestThread implements Runnable {

    TestThread() {
        System.out.println("test build");
    }


    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("test Runnable" + i);
            Thread.yield();
        }
        System.out.println("test Runnable end");
    }

    public static void main(String[] args) {
        ExecutorService t = Executors.newSingleThreadExecutor();

        t.execute(new TestThread());
        t.shutdown();
    }
}
