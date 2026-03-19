package com.hzf.guigu.common.exception;


import com.hzf.guigu.common.result.ResponseEnum;
import com.hzf.guigu.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理类
 * 需要扫描该类，才能被 Spring 管理，才能被 SpringBoot 启动类扫描到，因此得在调用该类的包或父包上添加 @ComponetScan 注解
 * @author hzf
 * @since 2026/3/19
 */
@Slf4j // 日志注解
@Component // 表示这是一个组件
@RestControllerAdvice // 表示全局异常处理
public class UnifiedExceptionHandler {

    /**
     * 未定义异常
     */
    @ExceptionHandler(value = Exception.class) // 当 controller 中抛出 Exception，则捕获
    public Result handle(Exception e) {
        log.error("统一异常处理类捕获异常：{}", e.toString());
        return Result.error();
    }

    /*
     * sql异常
     */
    @ExceptionHandler(value = BadSqlGrammarException.class) // 当 controller 中抛出 Exception，则捕获
    public Result handle(BadSqlGrammarException e) {
        log.error("统一异常处理类捕获异常：{}", e.toString());
        return Result.other(ResponseEnum.BAD_SQL_GRAMMAR_ERROR).message(e.getMessage());
    }
}
