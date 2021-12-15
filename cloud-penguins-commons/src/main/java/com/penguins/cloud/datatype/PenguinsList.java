package com.penguins.cloud.datatype;

/**
 * 自定义List
 *
 * @author 郑冰
 * @date 2021/10/26 22:10
 * @since jdk8
 **/
public class PenguinsList<T extends Object> {

    /**
     * 默认初始容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] penguins;

    private int capacity=0;

    /**
     * 默认构造器，实例化一个初始容量的对象数组
     */
    public PenguinsList(){
        this.penguins = new Object[DEFAULT_CAPACITY];
    }

    /**
     * 设置初始长度的构造方法
     * @param length int
     */
    public PenguinsList(int length){
        this.penguins = new Object[length];
    }

    /**
     * 给线性表添加元素
     * 如果遇到数组长度不够的情况时，自动将原容量*2扩容
     * @param t 元素
     */
    public void add(T t){
        if (this.penguins.length-1>=capacity) {
            this.penguins[capacity] = t;
            capacity++;
        }else{
            Object[] copy = new Object[this.penguins.length*2];
            for (int i = 0; i < this.penguins.length; i++) {
                copy[i]=this.penguins[i];
            }
            this.penguins = copy;
            this.penguins[capacity] = t;
            capacity++;
            // 扩容，再添加元素
        }
    }

    /**
     * 获得线性表已使用的长度
     * @return Integer
     */
    public int size(){
        return this.capacity;
    }

    /**
     * 获得元素
     * @param index 元素索引
     * @return T
     */
    public T get(int index){
        return (T) this.penguins[index];
    }

    public static void main(String[] args) {
        PenguinsList<String> penguinsList= new PenguinsList<>();
        
        penguinsList.add("a");
        penguinsList.add("a");
        penguinsList.add("a");
        penguinsList.add("a");
        penguinsList.add("a");
        penguinsList.add("a");
        penguinsList.add("a");
        penguinsList.add("a");
        penguinsList.add("a");
        penguinsList.add("a");
        penguinsList.add("a");

        System.out.println(penguinsList.size());
        System.out.println(penguinsList.get(10));
    }
}
