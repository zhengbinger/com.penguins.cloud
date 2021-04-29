package com.penguins.cloud.auth.provider.service.impl;

import com.penguins.cloud.auth.api.entity.OauthCode;
import com.penguins.cloud.auth.api.service.OauthCodeService;
import com.penguins.cloud.auth.provider.repository.OauthCodeDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (OauthCode)表服务实现类
 *
 * @author makejava
 * @since 2021-04-29 10:51:38
 */
@Service("oauthCodeService")
public class OauthCodeServiceImpl implements OauthCodeService {
  @Resource private OauthCodeDao oauthCodeDao;

  /**
   * 通过ID查询单条数据
   *
   * @param
   * @return 实例对象
   */
  @Override
  public OauthCode queryById() {
    return this.oauthCodeDao.queryById();
  }

  /**
   * 查询多条数据
   *
   * @param offset 查询起始位置
   * @param limit 查询条数
   * @return 对象列表
   */
  @Override
  public List<OauthCode> queryAllByLimit(int offset, int limit) {
    return this.oauthCodeDao.queryAllByLimit(offset, limit);
  }

  /**
   * 新增数据
   *
   * @param oauthCode 实例对象
   * @return 实例对象
   */
  @Override
  public OauthCode insert(OauthCode oauthCode) {
    this.oauthCodeDao.insert(oauthCode);
    return oauthCode;
  }

  /**
   * 修改数据
   *
   * @param oauthCode 实例对象
   * @return 实例对象
   */
  @Override
  public OauthCode update(OauthCode oauthCode) {
    this.oauthCodeDao.update(oauthCode);
    return oauthCode;
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
