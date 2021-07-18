package com.penguins.cloud.commons.web;

import java.io.Serializable;

/**
 * 通用 Response 结果封装
 *
 * @param <T>
 * @author zhengbing
 * @date 2021/4/26 19:17
 * @email mydreambing@126.com
 */
public class RspResult<T> implements Serializable {

  private static final long serialVersionUID = -1026921968095321733L;

  public RspResult() {}

  public RspResult(int cpde, T data, String message) {
    super();
    setData(data);
    setCode(code);
    setMessage(message);
  }

  public RspResult(int result, T data) {
    super();
    setData(data);
    setCode(result);
  }

  /** 响应状态 */
  private int code = 0;

  /** 响应数据 */
  private T data;

  /** 响应错误信息 */
  private String message;

  public int getCode() {
    return code;
  }

  public RspResult<T> setCode(int code) {
    this.code = code;
    return this;
  }

  public T getData() {
    return data;
  }

  public RspResult<T> setData(T data) {
    this.data = data;
    return this;
  }

  public String getMessage() {
    return message;
  }

  public RspResult<T> setMessage(String message) {
    this.message = message;
    return this;
  }

  public static <T> RspResult<T> success() {
    return RspResult.success(null);
  }

  public static <T> RspResult<T> success(T data) {
    return RspResult.fail(RspResultStatus.success.code, data, RspResultStatus.success.message);
  }

  public static <T> RspResult<T> success(int code, T data, String message) {
    RspResult<T> result = new RspResult<>();
    result.setCode(code);
    result.setMessage(message);
    result.setData(data);
    return result;
  }

  public static <T> RspResult<T> fail() {
    return RspResult.fail(RspResultStatus.fail.code, null, RspResultStatus.fail.message);
  }

  public static <T> RspResult<T> fail(int code) {
    return RspResult.fail(code, null, RspResultStatus.fail.message);
  }

  public static <T> RspResult<T> fail(String message) {
    return RspResult.fail(RspResultStatus.fail.code, null, message);
  }

  public static <T> RspResult<T> fail(int code, T data) {
    return RspResult.fail(code, data, RspResultStatus.fail.message);
  }

  public static <T> RspResult<T> fail(T data, String message) {
    return RspResult.fail(RspResultStatus.fail.code, data, message);
  }

  public static <T> RspResult<T> fail(int code, T data, String message) {
    RspResult<T> result = new RspResult<>();
    result.setCode(code);
    result.setMessage(message);
    result.setData(data);
    return result;
  }

  /**
   * 响应状态
   */
  public enum RspResultStatus {
    /**
     * 成功
     */
    success(200, "success"),
    /**
     * 失败
     */
    fail(500, "fail");

    private int code;
    private String message;

    int getCode() {
      return code;
    }

    String getMessage() {
      return message;
    }

    RspResultStatus(int code, String message) {
      this.code = code;
      this.message = message;
    }
  }
}
