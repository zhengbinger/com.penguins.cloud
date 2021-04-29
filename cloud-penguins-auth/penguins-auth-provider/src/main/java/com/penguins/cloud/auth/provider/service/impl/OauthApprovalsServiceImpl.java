package com.penguins.cloud.auth.provider.service.impl;

import com.penguins.cloud.auth.api.entity.OauthApprovals;
import com.penguins.cloud.auth.api.service.OauthApprovalsService;
import com.penguins.cloud.auth.provider.repository.OauthApprovalsDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OauthApprovals)表服务实现类
 *
 * @author makejava
 * @since 2021-04-29 10:50:52
 */
@Service("oauthApprovalsService")
public class OauthApprovalsServiceImpl implements OauthApprovalsService {
  @Resource private OauthApprovalsDao oauthApprovalsDao;

  /**
   * 通过ID查询单条数据
   *
   * @param
   * @return 实例对象
   */
  @Override
  public OauthApprovals queryById() {
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
  public List<OauthApprovals> queryAllByLimit(int offset, int limit) {
    return this.oauthApprovalsDao.queryAllByLimit(offset, limit);
  }

  /**
   * 新增数据
   *
   * @param oauthApprovals 实例对象
   * @return 实例对象
   */
  @Override
  public OauthApprovals insert(OauthApprovals oauthApprovals) {
    this.oauthApprovalsDao.insert(oauthApprovals);
    return oauthApprovals;
  }

  /**
   * 修改数据
   *
   * @param oauthApprovals 实例对象
   * @return 实例对象
   */
  @Override
  public OauthApprovals update(OauthApprovals oauthApprovals) {
    this.oauthApprovalsDao.update(oauthApprovals);
    return oauthApprovals;
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
