package com.penguins.cloud.auth.api.service;

import com.penguins.cloud.auth.api.entity.OauthAccessToken;

import java.util.List;

/**
 * (OauthAccessToken)表服务接口
 *
 * @author makejava
 * @since 2021-04-29 09:51:40
 */
public interface OauthAccessTokenService {

  /**
   * 通过ID查询单条数据
   *
   * @param authenticationId 主键
   * @return 实例对象
   */
  OauthAccessToken queryById(String authenticationId);

  /**
   * 查询多条数据
   *
   * @param offset 查询起始位置
   * @param limit 查询条数
   * @return 对象列表
   */
  List<OauthAccessToken> queryAllByLimit(int offset, int limit);

  /**
   * 新增数据
   *
   * @param oauthAccessToken 实例对象
   * @return 实例对象
   */
  OauthAccessToken insert(OauthAccessToken oauthAccessToken);

  /**
   * 修改数据
   *
   * @param oauthAccessToken 实例对象
   * @return 实例对象
   */
  OauthAccessToken update(OauthAccessToken oauthAccessToken);

  /**
   * 通过主键删除数据
   *
   * @param authenticationId 主键
   * @return 是否成功
   */
  boolean deleteById(String authenticationId);
}
