package com.penguins.cloud.stream.thread.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author 郑冰
 * @date 2021/8/27 14:39
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class TestSleep extends LiftOff {

    @Override
    public void run() {

        while (countDown-- > 0) {
            System.out.print(status());
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService e = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            e.execute(new TestSleep());
        }
        e.shutdown();
    }
}
