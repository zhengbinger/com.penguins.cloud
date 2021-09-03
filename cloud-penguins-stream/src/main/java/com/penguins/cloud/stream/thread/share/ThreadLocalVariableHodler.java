package com.penguins.cloud.stream.thread.share;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author 郑冰
 * @date 2021/9/2 11:37
 * @email mydreambing@126.com
 * @since jdk8
 **/
class Accessor implements Runnable {
    private final int id;

    public Accessor(int idn) {
        id = idn;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            ThreadLocalVariableHodler.increment();
            System.out.println(this);
            Thread.yield();
        }
    }

    @Override
    public String toString() {
        return "#" + id + ":" + ThreadLocalVariableHodler.get();
    }
}

public class ThreadLocalVariableHodler {

    private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
        private Random rd = new Random(47);

        @Override
        protected synchronized Integer initialValue() {
            return rd.nextInt(10000);
        }
    };

    public static void increment() {
        value.set(value.get() + 1);
    }

    public static Integer get() {
        return value.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exe = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exe.execute(new Accessor(i));
        }
        TimeUnit.SECONDS.sleep(5);
        exe.shutdown();
    }
}
