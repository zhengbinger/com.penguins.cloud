package com.penguins.cloud.files.api.entity;

/**
 * 文件记录实体类
 *
 * @author zhengbing
 * @date 2021/4/25 15:57
 * @email mydreambing@126.com
 */
public class FileRecord {

    private long id;

    private String filename;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public String toString() {
        return "FileRecord{" + "id=" + id + ", filename='" + filename + '\'' + '}';
    }
}
