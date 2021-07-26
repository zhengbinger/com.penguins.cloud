package com.penguins.cloud.auth.provider.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.penguins.cloud.auth.api.entity.OauthClientDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (OauthClientDetails)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-29 10:51:07
 */
@Mapper
public interface OauthClientDetailsDao extends BaseMapper<OauthClientDetails> {

  /**
   * 通过ID查询单条数据
   *
   * @param clientId 主键
   * @return 实例对象
   */
  OauthClientDetails queryById(String clientId);

  /**
   * 查询指定行数据
   *
   * @param offset 查询起始位置
   * @param limit 查询条数
   * @return 对象列表
   */
  List<OauthClientDetails> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

  /**
   * 通过实体作为筛选条件查询
   *
   * @param oauthClientDetails 实例对象
   * @return 对象列表
   */
  List<OauthClientDetails> queryAll(OauthClientDetails oauthClientDetails);

  /**
   * 新增数据
   *
   * @param oauthClientDetails 实例对象
   * @return 影响行数
   */
  @Override
  int insert(OauthClientDetails oauthClientDetails);

  /**
   * 批量新增数据（MyBatis原生foreach方法）
   *
   * @param entities List<OauthClientDetails> 实例对象列表
   * @return 影响行数
   */
  int insertBatch(@Param("entities") List<OauthClientDetails> entities);

  /**
   * 批量新增或按主键更新数据（MyBatis原生foreach方法）
   *
   * @param entities List<OauthClientDetails> 实例对象列表
   * @return 影响行数
   */
  int insertOrUpdateBatch(@Param("entities") List<OauthClientDetails> entities);

  /**
   * 修改数据
   *
   * @param oauthClientDetails 实例对象
   * @return 影响行数
   */
  int update(OauthClientDetails oauthClientDetails);

  /**
   * 通过主键删除数据
   *
   * @param clientId 主键
   * @return 影响行数
   */
  int deleteById(String clientId);
}
