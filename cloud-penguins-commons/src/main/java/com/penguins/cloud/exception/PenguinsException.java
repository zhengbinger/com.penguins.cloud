package com.penguins.cloud.exception;

/**
 * penguins 自定义异常基类
 *
 * @author zhengbing
 * @date 2021/5/6 11:40
 * @email mydreambing@126.com
 */
public class PenguinsException extends RuntimeException {
    private static final long serialVersionUID = -3286131001092080241L;

    public PenguinsException() {
        super();
    }

    public PenguinsException(String message) {
        super(message);
    }

    public PenguinsException(String message, int code) {
        super(message);
    }
}
