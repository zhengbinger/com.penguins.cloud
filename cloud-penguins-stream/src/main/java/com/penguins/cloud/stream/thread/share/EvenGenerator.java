package com.penguins.cloud.stream.thread.share;

/**
 * @author 郑冰
 * @date 2021/8/30 17:10
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class EvenGenerator extends IntGenerator {

    private int curretEvenValue = 0;

    @Override
    public int next() {

        ++curretEvenValue;
        Thread.yield();
        ++curretEvenValue;
        return curretEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
