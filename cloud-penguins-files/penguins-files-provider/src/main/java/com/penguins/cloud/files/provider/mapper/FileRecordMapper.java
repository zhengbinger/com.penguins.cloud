package com.penguins.cloud.files.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.penguins.cloud.files.api.entity.FileRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhengbing
 * @date 2021/4/25 16:00
 * @email mydreambing@126.com
 */
@Mapper
public interface FileRecordMapper extends BaseMapper<FileRecord> {
}
