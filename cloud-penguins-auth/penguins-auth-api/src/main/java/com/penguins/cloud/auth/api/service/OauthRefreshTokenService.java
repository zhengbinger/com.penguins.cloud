package com.penguins.cloud.auth.api.service;

import com.penguins.cloud.auth.api.entity.OauthRefreshToken;

import java.util.List;

/**
 * (OauthRefreshToken)表服务接口
 *
 * @author makejava
 * @since 2021-04-29 09:51:43
 */
public interface OauthRefreshTokenService {

  /**
   * 通过ID查询单条数据
   *
   * @param
   * @return 实例对象
   */
  OauthRefreshToken queryById();

  /**
   * 查询多条数据
   *
   * @param offset 查询起始位置
   * @param limit 查询条数
   * @return 对象列表
   */
  List<OauthRefreshToken> queryAllByLimit(int offset, int limit);

  /**
   * 新增数据
   *
   * @param oauthRefreshToken 实例对象
   * @return 实例对象
   */
  OauthRefreshToken insert(OauthRefreshToken oauthRefreshToken);

  /**
   * 修改数据
   *
   * @param oauthRefreshToken 实例对象
   * @return 实例对象
   */
  OauthRefreshToken update(OauthRefreshToken oauthRefreshToken);

  /**
   * 通过主键删除数据
   *
   * @param
   * @return 是否成功
   */
  boolean deleteById();
}
