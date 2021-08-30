package com.penguins.cloud.stream.thread.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author 郑冰
 * @date 2021/8/27 16:59
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class TestDeamonFormFactory implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread() + ":" + this);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("InterruptedException");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool(new TestDeamonFactory());
        for (int i = 0; i < 10; i++) {
            exec.execute(new TestDeamonFormFactory());
            System.out.println(i);
        }
        System.out.println("main start");
        TimeUnit.MILLISECONDS.sleep(500);
    }
}
