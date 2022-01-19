package com.penguins.cloud.files.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.penguins.cloud.files.api.entity.FileRecord;
import com.penguins.cloud.files.provider.mapper.FileRecordMapper;
import com.penguins.cloud.files.provider.service.FileRecordService;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author zhengbing
 * @date 2021/4/25 16:05
 * @email mydreambing@126.com
 */
@Service
public class FileRecordServiceImpl extends ServiceImpl<FileRecordMapper, FileRecord>
        implements FileRecordService {

    @Override
    public FileRecord getById(Serializable id) {
        return super.getById(id);
    }
}
