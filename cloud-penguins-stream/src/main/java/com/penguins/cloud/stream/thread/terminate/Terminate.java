package com.penguins.cloud.stream.thread.terminate;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author 郑冰
 * @date 2021/9/2 16:36
 * @email mydreambing@126.com
 * @since jdk8
 **/
class SleepBlocked implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("SleepBlocked is interrupt Exception");
        }

        System.out.println("Existing SleepBlocked run");
    }
}

class IOBlocked implements Runnable {

    private InputStream in;

    public IOBlocked(InputStream is) {
        in = is;
    }

    @Override
    public void run() {

        try {
            System.out.println("Waiting for read:");
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupt from IO Blocked");
            } else {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Existing IOBlocked run");
    }
}

class SychronizedBlocked implements Runnable {

    public synchronized void f() {
        while (true) {
            Thread.yield();
        }
    }

    public SychronizedBlocked() {
        new Thread() {
            @Override
            public void run() {
                f();
            }
        };
    }

    @Override
    public void run() {
        System.out.println("Trying to call f()");
        f();
        System.out.println("Existing SychronizedBlocked run");
    }
}

public class Terminate {

    private static ExecutorService exec = Executors.newCachedThreadPool();

    static void test(Runnable r) throws InterruptedException {
        Future<?> f = exec.submit(r);
        TimeUnit.SECONDS.sleep(10);
        System.out.println("Interrupted " + r.getClass().getName());
        f.cancel(true);
        System.out.println("send to Interrupt " + r.getClass().getName());
    }

    public static void main(String[] args) {
        try {
            test(new SleepBlocked());
            test(new IOBlocked(System.in));
            test(new SychronizedBlocked());
            TimeUnit.SECONDS.sleep(3);
            System.out.println("Aborting With System.exit(0)");
            System.exit(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
