package com.penguins.cloud.auth.provider.service.impl;

import com.penguins.cloud.auth.api.entity.OauthAccessToken;
import com.penguins.cloud.auth.api.service.OauthAccessTokenService;
import com.penguins.cloud.auth.provider.repository.OauthAccessTokenDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OauthAccessToken)表服务实现类
 *
 * @author makejava
 * @since 2021-04-29 10:50:35
 */
@Service("oauthAccessTokenService")
public class OauthAccessTokenServiceImpl implements OauthAccessTokenService {
  @Resource private OauthAccessTokenDao oauthAccessTokenDao;

  /**
   * 通过ID查询单条数据
   *
   * @param authenticationId 主键
   * @return 实例对象
   */
  @Override
  public OauthAccessToken queryById(String authenticationId) {
    return this.oauthAccessTokenDao.queryById(authenticationId);
  }

  /**
   * 查询多条数据
   *
   * @param offset 查询起始位置
   * @param limit 查询条数
   * @return 对象列表
   */
  @Override
  public List<OauthAccessToken> queryAllByLimit(int offset, int limit) {
    return this.oauthAccessTokenDao.queryAllByLimit(offset, limit);
  }

  /**
   * 新增数据
   *
   * @param oauthAccessToken 实例对象
   * @return 实例对象
   */
  @Override
  public OauthAccessToken insert(OauthAccessToken oauthAccessToken) {
    this.oauthAccessTokenDao.insert(oauthAccessToken);
    return oauthAccessToken;
  }

  /**
   * 修改数据
   *
   * @param oauthAccessToken 实例对象
   * @return 实例对象
   */
  @Override
  public OauthAccessToken update(OauthAccessToken oauthAccessToken) {
    this.oauthAccessTokenDao.update(oauthAccessToken);
    return this.queryById(oauthAccessToken.getAuthenticationId());
  }

  /**
   * 通过主键删除数据
   *
   * @param authenticationId 主键
   * @return 是否成功
   */
  @Override
  public boolean deleteById(String authenticationId) {
    return this.oauthAccessTokenDao.deleteById(authenticationId) > 0;
  }
}
