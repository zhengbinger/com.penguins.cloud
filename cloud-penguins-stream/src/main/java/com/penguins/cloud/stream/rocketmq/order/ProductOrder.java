package com.penguins.cloud.stream.rocketmq.order;

/**
 * @author zhengbing
 * @date 2021/4/19 11:30
 * @email mydreambing@126.com
 */
public class ProductOrder {

  private String orderId;
  private String type;

  public ProductOrder(String orderId, String type) {
    this.orderId = orderId;
    this.type = type;
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "ProductOrder{" + "orderId='" + orderId + '\'' + ", type='" + type + '\'' + '}';
  }
}
