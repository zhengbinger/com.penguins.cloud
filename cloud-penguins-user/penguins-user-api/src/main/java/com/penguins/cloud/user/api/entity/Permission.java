package com.penguins.cloud.user.api.entity;

import java.io.Serializable;

/**
 * Permission 实体类
 *
 * @author zhengbing
 * @date 2021/4/29 17:30
 * @email mydreambing@126.com
 */
public class Permission implements Serializable {

  private static final long serialVersionUID = 7030697656958999757L;
  private long id;
  private String permissionCode;
  private String permissionName;
  private String permissionDesc;

  public long getId() {
    return id;
  }

  public Permission setId(long id) {
    this.id = id;
    return this;
  }

  public String getPermissionCode() {
    return permissionCode;
  }

  public Permission setPermissionCode(String permissionCode) {
    this.permissionCode = permissionCode;
    return this;
  }

  public String getPermissionName() {
    return permissionName;
  }

  public Permission setPermissionName(String permissionName) {
    this.permissionName = permissionName;
    return this;
  }

  public String getPermissionDesc() {
    return permissionDesc;
  }

  public Permission setPermissionDesc(String permissionDesc) {
    this.permissionDesc = permissionDesc;
    return this;
  }
}
