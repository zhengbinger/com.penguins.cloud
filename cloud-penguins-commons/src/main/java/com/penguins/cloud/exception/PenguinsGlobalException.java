package com.penguins.cloud.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhengbing
 * @date 2021/5/6 10:13
 * @email mydreambing@126.com
 */
@ControllerAdvice
public class PenguinsGlobalException extends ResponseEntityExceptionHandler {

  /**
   * 全局异常处理
   *
   * @param request http 请求
   * @param e exception
   * @return error
   */
  @ExceptionHandler(Exception.class)
  ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable e) {
    if (e instanceof PenguinsException) {
      // 自定义异常
    } else if (e instanceof NullPointerException) {
      // 空指针异常
    } else {
      // 其他异常
    }
    return null;
  }
}
