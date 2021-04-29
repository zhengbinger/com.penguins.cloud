package com.penguins.cloud.auth.api.service;

import com.penguins.cloud.auth.api.entity.OauthCode;

import java.util.List;

/**
 * (OauthCode)表服务接口
 *
 * @author makejava
 * @since 2021-04-29 09:51:43
 */
public interface OauthCodeService {

  /**
   * 通过ID查询单条数据
   *
   * @param
   * @return 实例对象
   */
  OauthCode queryById();

  /**
   * 查询多条数据
   *
   * @param offset 查询起始位置
   * @param limit 查询条数
   * @return 对象列表
   */
  List<OauthCode> queryAllByLimit(int offset, int limit);

  /**
   * 新增数据
   *
   * @param oauthCode 实例对象
   * @return 实例对象
   */
  OauthCode insert(OauthCode oauthCode);

  /**
   * 修改数据
   *
   * @param oauthCode 实例对象
   * @return 实例对象
   */
  OauthCode update(OauthCode oauthCode);

  /**
   * 通过主键删除数据
   *
   * @return 是否成功
   */
  boolean deleteById();
}
