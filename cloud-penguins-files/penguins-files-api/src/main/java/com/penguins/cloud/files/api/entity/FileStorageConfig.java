package com.penguins.cloud.files.api.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 文件存储配置实体类
 *
 * @author 郑冰
 * @date 2022/1/20 10:14
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class FileStorageConfig implements Serializable {

    private static final long serialVersionUID = -3000050657313123417L;
    
    private long id;
    private short platform;
    private String endpoint;
    private String account;
    private String password;
    private String defaultBucket;
    private boolean status;
    private String creator;
    private LocalDateTime createTime;
    private String updator;
    private LocalDateTime updateTime;

    public long getId() {
        return id;
    }

    public FileStorageConfig setId(long id) {
        this.id = id;
        return this;
    }

    public short getPlatform() {
        return platform;
    }

    public FileStorageConfig setPlatform(short platform) {
        this.platform = platform;
        return this;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public FileStorageConfig setEndpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    public String getAccount() {
        return account;
    }

    public FileStorageConfig setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public FileStorageConfig setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getDefaultBucket() {
        return defaultBucket;
    }

    public FileStorageConfig setDefaultBucket(String defaultBucket) {
        this.defaultBucket = defaultBucket;
        return this;
    }

    public boolean isStatus() {
        return status;
    }

    public FileStorageConfig setStatus(boolean status) {
        this.status = status;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public FileStorageConfig setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public FileStorageConfig setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getUpdator() {
        return updator;
    }

    public FileStorageConfig setUpdator(String updator) {
        this.updator = updator;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public FileStorageConfig setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
