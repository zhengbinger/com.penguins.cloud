package com.penguins.cloud.auth.provider.service.impl;

import com.penguins.cloud.auth.api.entity.OauthRefreshToken;
import com.penguins.cloud.auth.api.service.OauthRefreshTokenService;
import com.penguins.cloud.auth.provider.repository.OauthRefreshTokenDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OauthRefreshToken)表服务实现类
 *
 * @author makejava
 * @since 2021-04-29 10:51:52
 */
@Service("oauthRefreshTokenService")
public class OauthRefreshTokenServiceImpl implements OauthRefreshTokenService {

  @Resource private OauthRefreshTokenDao oauthRefreshTokenDao;

  /**
   * 通过ID查询单条数据
   *
   * @param
   * @return 实例对象
   */
  @Override
  public OauthRefreshToken queryById() {
    return null;
  }

  /**
   * 查询多条数据
   *
   * @param offset 查询起始位置
   * @param limit 查询条数
   * @return 对象列表
   */
  @Override
  public List<OauthRefreshToken> queryAllByLimit(int offset, int limit) {
    return this.oauthRefreshTokenDao.queryAllByLimit(offset, limit);
  }

  /**
   * 新增数据
   *
   * @param oauthRefreshToken 实例对象
   * @return 实例对象
   */
  @Override
  public OauthRefreshToken insert(OauthRefreshToken oauthRefreshToken) {
    this.oauthRefreshTokenDao.insert(oauthRefreshToken);
    return oauthRefreshToken;
  }

  /**
   * 修改数据
   *
   * @param oauthRefreshToken 实例对象
   * @return 实例对象
   */
  @Override
  public OauthRefreshToken update(OauthRefreshToken oauthRefreshToken) {
    this.oauthRefreshTokenDao.update(oauthRefreshToken);
    return oauthRefreshToken;
  }

  /**
   * 通过主键删除数据
   *
   * @param
   * @return 是否成功
   */
  @Override
  public boolean deleteById() {
    return false;
  }
}
