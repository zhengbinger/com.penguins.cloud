package com.penguins.cloud.auth.provider.service.impl;

import com.penguins.cloud.auth.api.entity.Clientdetails;
import com.penguins.cloud.auth.api.service.ClientdetailsService;
import com.penguins.cloud.auth.provider.repository.ClientdetailsDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Clientdetails)表服务实现类
 *
 * @author makejava
 * @since 2021-04-29 10:52:30
 */
@Service("clientdetailsService")
public class ClientdetailsServiceImpl implements ClientdetailsService {

  @Resource private ClientdetailsDao clientdetailsDao;

  /**
   * 通过ID查询单条数据
   *
   * @param appid 主键
   * @return 实例对象
   */
  @Override
  public Clientdetails queryById(String appid) {
    return this.queryById(appid);
  }

  /**
   * 查询多条数据
   *
   * @param offset 查询起始位置
   * @param limit 查询条数
   * @return 对象列表
   */
  @Override
  public List<Clientdetails> queryAllByLimit(int offset, int limit) {
    return this.clientdetailsDao.queryAllByLimit(offset, limit);
  }

  /**
   * 新增数据
   *
   * @param clientdetails 实例对象
   * @return 实例对象
   */
  @Override
  public Clientdetails insert(Clientdetails clientdetails) {
    this.clientdetailsDao.insert(clientdetails);
    return clientdetails;
  }

  /**
   * 修改数据
   *
   * @param clientdetails 实例对象
   * @return 实例对象
   */
  @Override
  public Clientdetails update(Clientdetails clientdetails) {
    this.clientdetailsDao.update(clientdetails);
    return this.queryById(clientdetails.getAppid());
  }

  /**
   * 通过主键删除数据
   *
   * @param appid 主键
   * @return 是否成功
   */
  @Override
  public boolean deleteById(String appid) {
    return this.clientdetailsDao.deleteById(appid) > 0;
  }
}
