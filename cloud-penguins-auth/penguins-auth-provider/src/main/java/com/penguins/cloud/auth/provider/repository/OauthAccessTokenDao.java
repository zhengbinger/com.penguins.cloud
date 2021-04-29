package com.penguins.cloud.auth.provider.repository;

import com.penguins.cloud.auth.api.entity.OauthAccessToken;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (OauthAccessToken)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-29 10:50:34
 */
@Mapper
public interface OauthAccessTokenDao {

  /**
   * 通过ID查询单条数据
   *
   * @param authenticationId 主键
   * @return 实例对象
   */
  OauthAccessToken queryById(String authenticationId);

  /**
   * 查询指定行数据
   *
   * @param offset 查询起始位置
   * @param limit 查询条数
   * @return 对象列表
   */
  List<OauthAccessToken> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

  /**
   * 通过实体作为筛选条件查询
   *
   * @param oauthAccessToken 实例对象
   * @return 对象列表
   */
  List<OauthAccessToken> queryAll(OauthAccessToken oauthAccessToken);

  /**
   * 新增数据
   *
   * @param oauthAccessToken 实例对象
   * @return 影响行数
   */
  int insert(OauthAccessToken oauthAccessToken);

  /**
   * 批量新增数据（MyBatis原生foreach方法）
   *
   * @param entities List<OauthAccessToken> 实例对象列表
   * @return 影响行数
   */
  int insertBatch(@Param("entities") List<OauthAccessToken> entities);

  /**
   * 批量新增或按主键更新数据（MyBatis原生foreach方法）
   *
   * @param entities List<OauthAccessToken> 实例对象列表
   * @return 影响行数
   */
  int insertOrUpdateBatch(@Param("entities") List<OauthAccessToken> entities);

  /**
   * 修改数据
   *
   * @param oauthAccessToken 实例对象
   * @return 影响行数
   */
  int update(OauthAccessToken oauthAccessToken);

  /**
   * 通过主键删除数据
   *
   * @param authenticationId 主键
   * @return 影响行数
   */
  int deleteById(String authenticationId);
}
