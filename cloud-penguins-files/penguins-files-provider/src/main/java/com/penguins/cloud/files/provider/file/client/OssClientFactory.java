package com.penguins.cloud.files.provider.file.client;


/**
 * 对象存储客户端获取工厂类
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
    public static <T> T getClient(Class<T> clazz) throws InstantiationException, IllegalAccessException {
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
    public static <T> T getClient(String clazz) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<T> clazzClass = (Class<T>) Class.forName(clazz);
        return clazzClass.newInstance();
    }


    public static void main(String[] args) {

//        try {
//            AliyunOssClient s = OssClientFactory.getClient(AliyunOssClient.class);
//            System.out.println(s.getClient());
//            System.out.println(1);
//        } catch (InstantiationException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
    }
}
