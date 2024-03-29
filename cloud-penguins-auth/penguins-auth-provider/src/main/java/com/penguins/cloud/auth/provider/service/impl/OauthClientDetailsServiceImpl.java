package com.penguins.cloud.auth.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.penguins.cloud.auth.api.entity.OauthClientDetails;
import com.penguins.cloud.auth.api.service.OauthClientDetailsService;
import com.penguins.cloud.auth.provider.repository.OauthClientDetailsDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OauthClientDetails)表服务实现类
 *
 * @author makejava
 * @since 2021-04-29 10:51:07
 */
@Service("oauthClientDetailsService")
public class OauthClientDetailsServiceImpl extends ServiceImpl<OauthClientDetailsDao, OauthClientDetails>
        implements OauthClientDetailsService {

  @Resource
  private OauthClientDetailsDao oauthClientDetailsDao;

  /**
   * 通过ID查询单条数据
   *
   * @param clientId 主键
   * @return 实例对象
   */
  @Override
  public OauthClientDetails queryById(String clientId) {
    return this.oauthClientDetailsDao.queryById(clientId);
  }

  /**
   * 查询多条数据
   *
   * @param offset 查询起始位置
   * @param limit 查询条数
   * @return 对象列表
   */
  @Override
  public List<OauthClientDetails> queryAllByLimit(int offset, int limit) {
    return this.oauthClientDetailsDao.queryAllByLimit(offset, limit);
  }

  /**
   * 新增数据
   *
   * @param oauthClientDetails 实例对象
   * @return 实例对象
   */
  @Override
  public OauthClientDetails insert(OauthClientDetails oauthClientDetails) {
    this.save(oauthClientDetails);
    return oauthClientDetails;
  }

  /**
   * 修改数据
   *
   * @param oauthClientDetails 实例对象
   * @return 实例对象
   */
  @Override
  public OauthClientDetails update(OauthClientDetails oauthClientDetails) {
    this.oauthClientDetailsDao.update(oauthClientDetails);
    return this.queryById(oauthClientDetails.getClientId());
  }

  /**
   * 通过主键删除数据
   *
   * @param clientId 主键
   * @return 是否成功
   */
  @Override
  public boolean deleteById(String clientId) {
    return this.oauthClientDetailsDao.deleteById(clientId) > 0;
  }
}
