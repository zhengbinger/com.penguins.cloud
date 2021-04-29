package com.penguins.cloud.auth.provider.repository;

import com.penguins.cloud.auth.api.entity.Clientdetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Clientdetails)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-29 10:52:30
 */
@Mapper
public interface ClientdetailsDao {

  /**
   * 通过ID查询单条数据
   *
   * @param appid 主键
   * @return 实例对象
   */
  Clientdetails queryById(String appid);

  /**
   * 查询指定行数据
   *
   * @param offset 查询起始位置
   * @param limit 查询条数
   * @return 对象列表
   */
  List<Clientdetails> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

  /**
   * 通过实体作为筛选条件查询
   *
   * @param clientdetails 实例对象
   * @return 对象列表
   */
  List<Clientdetails> queryAll(Clientdetails clientdetails);

  /**
   * 新增数据
   *
   * @param clientdetails 实例对象
   * @return 影响行数
   */
  int insert(Clientdetails clientdetails);

  /**
   * 批量新增数据（MyBatis原生foreach方法）
   *
   * @param entities List<Clientdetails> 实例对象列表
   * @return 影响行数
   */
  int insertBatch(@Param("entities") List<Clientdetails> entities);

  /**
   * 批量新增或按主键更新数据（MyBatis原生foreach方法）
   *
   * @param entities List<Clientdetails> 实例对象列表
   * @return 影响行数
   */
  int insertOrUpdateBatch(@Param("entities") List<Clientdetails> entities);

  /**
   * 修改数据
   *
   * @param clientdetails 实例对象
   * @return 影响行数
   */
  int update(Clientdetails clientdetails);

  /**
   * 通过主键删除数据
   *
   * @param appid 主键
   * @return 影响行数
   */
  int deleteById(String appid);
}
