package com.penguins.cloud.auth.provider.repository;

import com.penguins.cloud.auth.api.entity.OauthRefreshToken;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (OauthRefreshToken)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-29 10:51:52
 */
@Mapper
public interface OauthRefreshTokenDao {

  /**
   * 查询指定行数据
   *
   * @param offset 查询起始位置
   * @param limit 查询条数
   * @return 对象列表
   */
  List<OauthRefreshToken> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

  /**
   * 通过实体作为筛选条件查询
   *
   * @param oauthRefreshToken 实例对象
   * @return 对象列表
   */
  List<OauthRefreshToken> queryAll(OauthRefreshToken oauthRefreshToken);

  /**
   * 新增数据
   *
   * @param oauthRefreshToken 实例对象
   * @return 影响行数
   */
  int insert(OauthRefreshToken oauthRefreshToken);

  /**
   * 批量新增数据（MyBatis原生foreach方法）
   *
   * @param entities List<OauthRefreshToken> 实例对象列表
   * @return 影响行数
   */
  int insertBatch(@Param("entities") List<OauthRefreshToken> entities);

  /**
   * 批量新增或按主键更新数据（MyBatis原生foreach方法）
   *
   * @param entities List<OauthRefreshToken> 实例对象列表
   * @return 影响行数
   */
  int insertOrUpdateBatch(@Param("entities") List<OauthRefreshToken> entities);

  /**
   * 修改数据
   *
   * @param oauthRefreshToken 实例对象
   * @return 影响行数
   */
  int update(OauthRefreshToken oauthRefreshToken);

  /**
   * 通过主键删除数据
   *
   * @param
   * @return 影响行数
   */
  int deleteById();
}
