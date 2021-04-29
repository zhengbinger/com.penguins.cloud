package com.penguins.cloud.auth.provider.repository;

import com.penguins.cloud.auth.api.entity.OauthCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (OauthCode)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-29 10:51:38
 */
@Mapper
public interface OauthCodeDao {

  /**
   * 通过ID查询单条数据
   *
   * @param
   * @return 实例对象
   */
  OauthCode queryById();

  /**
   * 查询指定行数据
   *
   * @param offset 查询起始位置
   * @param limit 查询条数
   * @return 对象列表
   */
  List<OauthCode> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

  /**
   * 通过实体作为筛选条件查询
   *
   * @param oauthCode 实例对象
   * @return 对象列表
   */
  List<OauthCode> queryAll(OauthCode oauthCode);

  /**
   * 新增数据
   *
   * @param oauthCode 实例对象
   * @return 影响行数
   */
  int insert(OauthCode oauthCode);

  /**
   * 批量新增数据（MyBatis原生foreach方法）
   *
   * @param entities List<OauthCode> 实例对象列表
   * @return 影响行数
   */
  int insertBatch(@Param("entities") List<OauthCode> entities);

  /**
   * 批量新增或按主键更新数据（MyBatis原生foreach方法）
   *
   * @param entities List<OauthCode> 实例对象列表
   * @return 影响行数
   */
  int insertOrUpdateBatch(@Param("entities") List<OauthCode> entities);

  /**
   * 修改数据
   *
   * @param oauthCode 实例对象
   * @return 影响行数
   */
  int update(OauthCode oauthCode);
}
