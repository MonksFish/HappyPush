package cn.monksfish.happypush.plugin.exception.advice;

import cn.monksfish.happypush.plugin.exception.ServiceException;
import cn.monksfish.happypush.plugin.exception.enums.SystemExceptionEnum;
import cn.monksfish.happypush.plugin.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

/**
 * 全局异常处理
 *
 * @author yan_wenjie
 * @date 2022/08/31
 */
@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException m) {
        String exMsg = m.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(","));
        log.warn("系统参数校验异常，异常信息:{},异常原因：{}", m.getMessage(), exMsg);
        return BaseResponse.fail(SystemExceptionEnum.PARAMETER_EXCEPTION.getExceptionCode(), exMsg);
    }

    @ExceptionHandler(ServiceException.class)
    public BaseResponse<Object> handleServiceException(ServiceException ex) {
        log.warn("系统业务逻辑异常，异常编码：{},异常信息：{}", ex.getErrorCode(), ex.getMessage());
        return BaseResponse.fail(ex.getErrorCode(), ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse<Object> handleException(Exception ex) {
        log.error("系统异常，异常信息：", ex);
        return BaseResponse.fail(SystemExceptionEnum.SYS_EXCEPTION.getExceptionCode(),
                SystemExceptionEnum.SYS_EXCEPTION.getExceptionMsg());
    }
}
