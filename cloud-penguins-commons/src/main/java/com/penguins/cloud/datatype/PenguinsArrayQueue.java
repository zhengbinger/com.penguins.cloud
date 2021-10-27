package com.penguins.cloud.datatype;

import java.util.Queue;

/**
 * @author 郑冰
 * @date 2021/10/26 23:20
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class PenguinsArrayQueue {

    private int maxSize = 10;
    private int front=-1;
    private int tail = -1;

    private int[] content;

    public PenguinsArrayQueue(){
        this.content = new int[this.maxSize];
    }

    public PenguinsArrayQueue(int arrMaxSize){
        this.content = new int[arrMaxSize];
    }
}
