package com.penguins.cloud.auth.provider.repository;

import com.penguins.cloud.auth.api.entity.OauthApprovals;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (OauthApprovals)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-29 10:50:52
 */
@Mapper
public interface OauthApprovalsDao {

  /**
   * 查询指定行数据
   *
   * @param offset 查询起始位置
   * @param limit 查询条数
   * @return 对象列表
   */
  List<OauthApprovals> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

  /**
   * 通过实体作为筛选条件查询
   *
   * @param oauthApprovals 实例对象
   * @return 对象列表
   */
  List<OauthApprovals> queryAll(OauthApprovals oauthApprovals);

  /**
   * 新增数据
   *
   * @param oauthApprovals 实例对象
   * @return 影响行数
   */
  int insert(OauthApprovals oauthApprovals);

  /**
   * 批量新增数据（MyBatis原生foreach方法）
   *
   * @param entities List<OauthApprovals> 实例对象列表
   * @return 影响行数
   */
  int insertBatch(@Param("entities") List<OauthApprovals> entities);

  /**
   * 批量新增或按主键更新数据（MyBatis原生foreach方法）
   *
   * @param entities List<OauthApprovals> 实例对象列表
   * @return 影响行数
   */
  int insertOrUpdateBatch(@Param("entities") List<OauthApprovals> entities);

  /**
   * 修改数据
   *
   * @param oauthApprovals 实例对象
   * @return 影响行数
   */
  int update(OauthApprovals oauthApprovals);
}
