package com.penguins.cloud.datatype;

/**
 * @author 郑冰
 * @date 2021/10/26 23:20
 * @since jdk8
 **/
public class PenguinsArrayQueue {

    /**
     * 数组默认最大容量
     */
    private int maxSize = 10;
    /**
     * 头部指针，指向队列头部的前一个位置
     */
    private int front = 0;
    /**
     * 尾部指针，指向队列尾部的位置
     */
    private int rear = -1;

    /**
     * 队列数据
     */
    private int[] content;

    /**
     * 构造器 - 使用默认容量创建队列
     */
    public PenguinsArrayQueue() {
        this.content = new int[this.maxSize];
    }

    /**
     * 构造器 - 使用指定容量创建队列
     *
     * @param arrMaxSize 指定队列容量
     */
    public PenguinsArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        this.content = new int[arrMaxSize];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public void add(int item) {
        if (isFull()) {
            throw new PenguinsArrayQueueException("队列已满，无法添加元素到队列");
        }
        content[++rear] = item;
    }

    public int out() {
        if (isEmpty()) {
            throw new PenguinsArrayQueueException("队列为空，无数据可取");
        }
        front++;
        return content[front];
    }

    public void show() {
        if (isEmpty()) {
            throw new PenguinsArrayQueueException("队列为空，无数据可展示");
        }
        for (int i = front; i < content.length; i++) {
            System.out.printf("content[%d]=%d\n", i, content[i]);
        }
    }

    public int getHead() {
        if (isEmpty()) {
            throw new PenguinsArrayQueueException("队列为空，无法得到头部数据");
        }
        return content[front];
    }

    public static void main(String[] args) {
        PenguinsArrayQueue queue = new PenguinsArrayQueue(3);
        queue.add(8);
        queue.add(8);
        queue.add(10);
        System.out.println(queue.getHead());
        queue.show();
        queue.out();
        queue.out();
        queue.out();
        System.out.println(queue.getHead());
        queue.show();
    }

    static class PenguinsArrayQueueException extends RuntimeException {

        private static final long serialVersionUID = 190064032008850057L;

        public PenguinsArrayQueueException() {
            super();
        }

        public PenguinsArrayQueueException(String message) {
            super(message);
        }
    }
}
