package com.hzf.guigu.common.exception;


import com.hzf.guigu.common.result.ResponseEnum;
import com.hzf.guigu.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 统一异常处理类  对异常按阶段进行分类，大体可以分成：进入Controller前的异常 和 业务层异常，
 * 需要扫描该类，才能被 Spring 管理，才能被 SpringBoot 启动类扫描到，因此得在调用该类的包或父包上添加 @ComponetScan 注解
 * @author hzf
 * @since 2026/3/19
 */
@Slf4j // 日志注解
@Component // 表示这是一个组件
@RestControllerAdvice // 表示全局异常处理
public class UnifiedExceptionHandler {

    /**  业务层异常
     * 未定义异常
     */
    @ExceptionHandler(value = Exception.class) // 当 controller 中抛出 Exception，则捕获
    public Result handle(Exception e) {
        log.error(e.getMessage(), e);
        return Result.error();
    }

    /**  业务层异常
     * sql异常
     */
    @ExceptionHandler(value = BadSqlGrammarException.class) // 当 controller 中抛出 Exception，则捕获
    public Result handle(BadSqlGrammarException e) {
        log.error(e.getMessage(), e);
        return Result.other(ResponseEnum.BAD_SQL_GRAMMAR_ERROR).message(e.getMessage());
    }

    /**  业务层异常
     * 业务异常,最常用，所有业务上的异常都可以调这个异常方法
     */
    @ExceptionHandler(value = BusinessException.class) // 当 controller 中抛出 BusinessException，则捕获
    public Result handle(BusinessException e) {
        log.error(e.getMessage(), e);
        return Result.error().message(e.getMessage()).code(e.getCode());
    }


    /**  Controller上一层相关异常
     * Controller上一层相关异常
     */
    @ExceptionHandler({
            NoHandlerFoundException.class,
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class,
            MissingPathVariableException.class,
            MissingServletRequestParameterException.class,
            TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            MethodArgumentNotValidException.class,
            HttpMediaTypeNotAcceptableException.class,
            ServletRequestBindingException.class,
            ConversionNotSupportedException.class,
            MissingServletRequestPartException.class,
            AsyncRequestTimeoutException.class
    })
    public Result handleServletException(Exception e) {
        log.error(e.getMessage(), e);
        //SERVLET_ERROR(-102, "servlet请求异常"),
        return Result.error().message(ResponseEnum.SERVLET_ERROR.getMessage()).code(ResponseEnum.SERVLET_ERROR.getCode());
    }
}
