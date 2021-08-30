package com.penguins.cloud.stream.thread.share;

/**
 * @author 郑冰
 * @date 2021/8/30 16:19
 * @email mydreambing@126.com
 * @since jdk8
 **/
public abstract class IntGenerator {

    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
