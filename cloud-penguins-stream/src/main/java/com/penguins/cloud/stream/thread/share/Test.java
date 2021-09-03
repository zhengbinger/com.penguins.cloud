package com.penguins.cloud.stream.thread.share;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 郑冰
 * @date 2021/9/2 10:29
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class Test {


    int a = 0;

    public void exe() {
        ExecutorService ex = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            ex.execute(new TestThread1());
        }
        ex.shutdown();
    }

    public static void main(String[] args) {
        new Test().exe();
    }

    class TestThread1 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                ++a;
            }
            System.out.println(Thread.currentThread().getName() + ": " + a);
        }
    }
}
