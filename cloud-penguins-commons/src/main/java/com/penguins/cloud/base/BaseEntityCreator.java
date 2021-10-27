package com.penguins.cloud.base;

import java.time.LocalDateTime;

/**
 * @author 郑冰
 * @date 2021/8/6 17:44
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class BaseEntityCreator implements BaseEntity{

    /**
     * 创建人
     */
    private String creator;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新人
     */
    private String updator;
    /**
     * 更新时间
     */
    private LocalDateTime lastUpdateTime;

    public String getCreator() {
        return creator;
    }

    public BaseEntity setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public BaseEntity setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getUpdator() {
        return updator;
    }

    public BaseEntity setUpdator(String updator) {
        this.updator = updator;
        return this;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public BaseEntity setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }
}
