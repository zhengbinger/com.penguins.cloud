package com.penguins.cloud.auth.provider.service.impl;

import com.penguins.cloud.auth.api.entity.OauthClientToken;
import com.penguins.cloud.auth.api.service.OauthClientTokenService;
import com.penguins.cloud.auth.provider.repository.OauthClientTokenDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OauthClientToken)表服务实现类
 *
 * @author makejava
 * @since 2021-04-29 10:51:22
 */
@Service("oauthClientTokenService")
public class OauthClientTokenServiceImpl implements OauthClientTokenService {
  @Resource private OauthClientTokenDao oauthClientTokenDao;

  /**
   * 通过ID查询单条数据
   *
   * @param authenticationId 主键
   * @return 实例对象
   */
  @Override
  public OauthClientToken queryById(String authenticationId) {
    return this.oauthClientTokenDao.queryById(authenticationId);
  }

  /**
   * 查询多条数据
   *
   * @param offset 查询起始位置
   * @param limit 查询条数
   * @return 对象列表
   */
  @Override
  public List<OauthClientToken> queryAllByLimit(int offset, int limit) {
    return this.oauthClientTokenDao.queryAllByLimit(offset, limit);
  }

  /**
   * 新增数据
   *
   * @param oauthClientToken 实例对象
   * @return 实例对象
   */
  @Override
  public OauthClientToken insert(OauthClientToken oauthClientToken) {
    this.oauthClientTokenDao.insert(oauthClientToken);
    return oauthClientToken;
  }

  /**
   * 修改数据
   *
   * @param oauthClientToken 实例对象
   * @return 实例对象
   */
  @Override
  public OauthClientToken update(OauthClientToken oauthClientToken) {
    this.oauthClientTokenDao.update(oauthClientToken);
    return this.queryById(oauthClientToken.getAuthenticationId());
  }

  /**
   * 通过主键删除数据
   *
   * @param authenticationId 主键
   * @return 是否成功
   */
  @Override
  public boolean deleteById(String authenticationId) {
    return this.oauthClientTokenDao.deleteById(authenticationId) > 0;
  }
}
