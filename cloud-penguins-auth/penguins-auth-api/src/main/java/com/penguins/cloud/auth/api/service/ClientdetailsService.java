package com.penguins.cloud.auth.api.service;

import com.penguins.cloud.auth.api.entity.Clientdetails;

import java.util.List;

/**
 * (Clientdetails)表服务接口
 *
 * @author makejava
 * @since 2021-04-29 09:51:40
 */
public interface ClientdetailsService {

  /**
   * 通过ID查询单条数据
   *
   * @param appid 主键
   * @return 实例对象
   */
  Clientdetails queryById(String appid);

  /**
   * 查询多条数据
   *
   * @param offset 查询起始位置
   * @param limit 查询条数
   * @return 对象列表
   */
  List<Clientdetails> queryAllByLimit(int offset, int limit);

  /**
   * 新增数据
   *
   * @param clientdetails 实例对象
   * @return 实例对象
   */
  Clientdetails insert(Clientdetails clientdetails);

  /**
   * 修改数据
   *
   * @param clientdetails 实例对象
   * @return 实例对象
   */
  Clientdetails update(Clientdetails clientdetails);

  /**
   * 通过主键删除数据
   *
   * @param appid 主键
   * @return 是否成功
   */
  boolean deleteById(String appid);
}
