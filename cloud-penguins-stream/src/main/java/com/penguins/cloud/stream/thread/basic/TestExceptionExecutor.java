package com.penguins.cloud.stream.thread.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author 郑冰
 * @date 2021/8/30 15:42
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class TestExceptionExecutor {

    static class TestException2 implements Runnable {

        @Override
        public void run() {
            Thread t = Thread.currentThread();
            System.out.println("run by ：" + t);
            System.out.println("eh:" + t.getUncaughtExceptionHandler());
            throw new RuntimeException("etst");
        }
    }

    static class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("catched:" + e);
            System.out.println("catched Message:" + e.getMessage());
        }
    }

    static class HandlerThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            System.out.println(this + "new Thread");
            Thread t = new Thread(r);
            System.out.println("created :" + t);
            t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            System.out.println("eh:" + t.getUncaughtExceptionHandler());
            return t;
        }
    }

    public static void main(String[] args) {
        try {
            ExecutorService es = Executors.newCachedThreadPool(new HandlerThreadFactory());
            es.execute(new TestException2());
        } catch (RuntimeException e) {
            System.out.println("test");
        }
    }
}
