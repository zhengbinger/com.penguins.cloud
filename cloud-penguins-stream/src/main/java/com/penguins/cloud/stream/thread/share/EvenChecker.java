package com.penguins.cloud.stream.thread.share;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 郑冰
 * @date 2021/8/30 16:24
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class EvenChecker implements Runnable {

    private IntGenerator intGenerator;

    private final int id;

    EvenChecker(IntGenerator g, int ident) {
        this.intGenerator = g;
        this.id = ident;
    }

    @Override
    public void run() {
        while (!intGenerator.isCanceled()) {
            int val = intGenerator.next();
            if (val % 2 != 0) {
                System.out.println("val: " + val + " not even!!!");
                intGenerator.cancel();
            }
        }
    }

    public static void test(IntGenerator ig, int count) {
        System.out.println("press Ctrl+C to exit");
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            es.execute(new EvenChecker(ig, i));
        }
        es.shutdown();
    }

    public static void test(IntGenerator ig) {
        test(ig, 10);
    }
}
