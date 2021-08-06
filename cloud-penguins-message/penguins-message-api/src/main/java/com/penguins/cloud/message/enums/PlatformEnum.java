package com.penguins.cloud.message.enums;

/**
 * 短信平台枚举
 *
 * @author 郑冰
 * @date 2021/8/6 18:09
 * @email mydreambing@126.com
 * @since jdk8
 **/
public enum PlatformEnum {

    /**
     * 阿里云
     */
    aliyun("阿里云", "阿里巴巴"),
    /**
     * 华为云
     */
    huawei("华为云", "华为"),
    /**
     * 腾讯云
     */
    tencent("腾讯云", "腾讯");


    private String platformName;
    private String company;

    PlatformEnum(String platformName, String company) {
        this.platformName = platformName;
        this.company = company;
    }

}
