package com.penguins.cloud.concurrent;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author 郑冰
 * @date 2021/12/4 01:00
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class ForkJoinCalculate extends RecursiveTask<Long> {
    private static final long serialVersionUID = -4296727388188380823L;
    private long start;
    private long end;

    public static final long TNRESHOLD = 10000;

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {

        long length = end - start;
        if (length <= TNRESHOLD) {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += 1;
            }
            return sum;
        } else {
            long middle = (start + end) / 2;
            ForkJoinCalculate left = new ForkJoinCalculate(start, middle);
            left.fork();
            ForkJoinCalculate right = new ForkJoinCalculate(middle + 1, end);
            right.fork();
            return left.join() + right.join();
        }
    }

    public static void main(String[] args) {
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> tasks = new ForkJoinCalculate(0, 10000000000000L);
        long sum = pool.invoke(tasks);
        Instant end = Instant.now();
        System.out.println(sum);
        System.out.println(Duration.between(start, end).toMillis());
    }

}
