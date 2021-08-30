package com.penguins.cloud.stream.thread.basic;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * 带返回值线程任务
 *
 * @author 郑冰
 * @date 2021/8/27 14:23
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class TestCallable implements Callable<String> {

    private int id;

    public TestCallable(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TestCallable " + id;
    }

    public static void main(String[] args) {
        ExecutorService e = Executors.newCachedThreadPool();
        ArrayList<Future<String>> s = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            s.add(e.submit(new TestCallable(11 + i)));
        }

        for (Future<String> st : s) {
            try {
                System.out.println(st.get());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } catch (ExecutionException ex) {
                ex.printStackTrace();
            } finally {
                e.shutdown();
            }
        }

    }
}
