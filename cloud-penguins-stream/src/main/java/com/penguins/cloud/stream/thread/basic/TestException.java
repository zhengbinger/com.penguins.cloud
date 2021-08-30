package com.penguins.cloud.stream.thread.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 郑冰
 * @date 2021/8/30 15:22
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class TestException implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException("test");
    }

//    public static void main(String[] args) {
    //    normal test
//        ExecutorService es = Executors.newCachedThreadPool();
//        es.execute(new TestException());
//    }

    public static void main(String[] args) {
        // normal test with catch
        try {

            ExecutorService es = Executors.newCachedThreadPool();
            es.execute(new TestException());
        } catch (RuntimeException e) {
            // doesn't work
            System.out.println("catched ");
        }

    }
}
