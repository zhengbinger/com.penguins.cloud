package com.penguins.cloud.files.provider.file.client;

import com.sun.istack.NotNull;

/**
 * 对象存储客户端获取
 *
 * @author 郑冰
 * @date 2022/1/19 18:16
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class OssClientFactory {

    /**
     * 根据类的Class 对象获取类的实例
     *
     * @param clazz
     * @param <T>
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static <T> T getClient(@NotNull Class<T> clazz) throws InstantiationException, IllegalAccessException {
        return clazz.newInstance();
    }

    /**
     * 根据类的全限定名称获取类的实例
     *
     * @param clazz
     * @param <T>
     * @return
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static <T> T getClient(@NotNull String clazz) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<T> clazzClass = (Class<T>) Class.forName(clazz);
        return clazzClass.newInstance();
    }


    public static void main(String[] args) {
        try {
            String s = OssClientFactory.getClient("java.lang.String");
            System.out.println(1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
