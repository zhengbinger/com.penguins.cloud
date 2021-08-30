package com.penguins.cloud.stream.thread.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 郑冰
 * @date 2021/8/27 14:39
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class TestPriority extends LiftOff {

    private int priority;

    TestPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while (countDown-- > 0) {
            System.out.print(status() + "\t" + Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority());
            System.out.println();
        }

    }

    public static void main(String[] args) {
        ExecutorService e = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            e.execute(new TestPriority(Thread.MIN_PRIORITY));
        }
        e.execute(new TestPriority(Thread.MAX_PRIORITY));
        e.shutdown();
    }
}
