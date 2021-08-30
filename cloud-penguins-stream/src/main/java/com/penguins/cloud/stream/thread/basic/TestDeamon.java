package com.penguins.cloud.stream.thread.basic;

import java.util.concurrent.TimeUnit;

/**
 * @author 郑冰
 * @date 2021/8/27 15:52
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class TestDeamon implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(200);
            System.out.println(Thread.currentThread().getName() + " " + this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread deamon = new Thread(new TestDeamon());
            deamon.setDaemon(true);
            deamon.start();
        }
        System.out.println("main started");
        try {
            TimeUnit.MILLISECONDS.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
