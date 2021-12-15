package com.penguins.cloud.concurrent;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

@SpringBootTest
public class ForkJoinCalculateTest {


    @Test
    public void test() {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> tasks = new ForkJoinCalculate(0, 100000000000L);
        long sum = pool.invoke(tasks);
        System.out.println(sum);
    }
}