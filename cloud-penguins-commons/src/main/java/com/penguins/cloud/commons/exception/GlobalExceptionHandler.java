package com.penguins.cloud.commons.exception;

import com.penguins.cloud.commons.web.RspResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;

/**
 * 全局统一异常处理
 *
 * @author 郑冰
 * @email mydreambing@126.com
 * @since jdk8
 **/
@Component
@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 系统自定义异常
     *
     * @param e PenguinsException
     * @return RspResult<Object>
     */
    @ExceptionHandler(value = PenguinsException.class)
    public RspResult<Object> handle(PenguinsException e) {
        e.printStackTrace();
        return RspResult.fail(e.getMessage());
    }

    /**
     * 空指针异常
     *
     * @param e NullPointerException
     * @return RspResult<Object>
     */
    @ExceptionHandler(value = NullPointerException.class)
    public RspResult<Object> handle(NullPointerException e) {
        e.printStackTrace();
        return RspResult.fail("【 BPM 系统内部错误！】");
    }

    /**
     * 400错误
     *
     * @param ex HttpMessageNotReadableException
     * @return RspResult<Object>
     */
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public RspResult<Object> requestNotReadable(HttpMessageNotReadableException ex) {
        ex.printStackTrace();
        return RspResult.fail(ex.getMessage());
    }

    /**
     * 400错误
     *
     * @param ex TypeMismatchException
     * @return RspResult<Object>
     */
    @ExceptionHandler({TypeMismatchException.class})
    public RspResult<Object> requestTypeMismatch(TypeMismatchException ex) {
        ex.printStackTrace();
        return RspResult.fail(ex.getMessage());
    }

    /**
     * 400错误
     *
     * @param ex MissingServletRequestParameterException
     * @return RspResult<Object>
     */
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public RspResult<Object> requestMissingServletRequest(
            MissingServletRequestParameterException ex) {
        ex.printStackTrace();
        return RspResult.fail(ex.getMessage());
    }

    /**
     * IO异常
     *
     * @param ex IOException
     * @return RspResult<Object>
     */
    @ExceptionHandler(IOException.class)
    public RspResult<Object> iOExceptionHandler(IOException ex) {
        ex.printStackTrace();
        return RspResult.fail(ex.getMessage());
    }

    /**
     * 405错误
     *
     * @param ex HttpRequestMethodNotSupportedException
     * @return RspResult<Object>
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public RspResult<Object> request405(HttpRequestMethodNotSupportedException ex) {
        ex.printStackTrace();
        return RspResult.fail(ex.getMessage());
    }

    /**
     * 超时异常
     *
     * @param ex SocketTimeoutException
     * @return RspResult<Object>
     */
    @ExceptionHandler(SocketTimeoutException.class)
    public RspResult<Object> socketTimeoutException(SocketTimeoutException ex) {
        ex.printStackTrace();
        return RspResult.fail(ex.getMessage());
    }

    /**
     * 处理入参异常
     *
     * @param e MethodArgumentNotValidException
     * @return RspResult<Object>
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public RspResult<Object> handleIllegalParamException(MethodArgumentNotValidException e) {
        e.printStackTrace();
        String message = "参数不合法";
        List<FieldError> errors = e.getBindingResult().getFieldErrors();
        if (errors.size() > 0) {
            message = errors.get(0).getDefaultMessage();
        }
        return RspResult.fail(message);
    }

    /**
     * 其他类型的运行时异常
     *
     * @param e RuntimeException
     * @return RspResult<Object>
     */
    @ExceptionHandler(value = Exception.class)
    public RspResult<Object> handle(Exception e) {
        e.printStackTrace();
        StackTraceElement element = e.getStackTrace()[0];
        log.error(
                "出现其他异常"
                        + e.getClass().getSimpleName()
                        + ",【"
                        + e.getMessage()
                        + "】"
                        + "所属类："
                        + element.getClassName()
                        + "，所属方法："
                        + element.getMethodName()
                        + "，所在行号："
                        + element.getLineNumber());
        return RspResult.fail("【 BPM 系统内部错误！】" + e.getMessage());
    }
}

