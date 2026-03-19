package com.hzf.guigu.common.result;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @description 统一返回结果封装
 * @author hzf
 * @date 2026/03/18
 */
@Data
public class Result {
    private Integer code;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    //创建私有构造方法，防止外部实例化
    private Result(){
    }

    /**
     * 创建静态方法，返回成功结果
     * @return Result
     */
    public static Result success(){
        Result result = new Result();
        result.setCode(ResponseEnum.SUCCESS.getCode());
        result.setMessage(ResponseEnum.SUCCESS.getMessage());
        return result;
    }

    /**
     * 创建静态方法，返回失败结果
     * @return Result
     */
    public static Result error(){
        Result result = new Result();
        result.setCode(ResponseEnum.ERROR.getCode());
        result.setMessage(ResponseEnum.ERROR.getMessage());
        return result;
    }

    /**
     * 创建静态方法，返回其他结果
     * @return Result
     */
    public static Result other(ResponseEnum responseEnum){ //动态获取结果枚举
        Result result = new Result();
        result.setCode(responseEnum.getCode());
        result.setMessage(responseEnum.getMessage());
        return result;
    }

    /**
     * 创建方法，返回结果数据
     * @param key 键
     * @param value 值
     * @return Result
     */
    public Result data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    /**
     * 创建方法，返回结果信息
     * @param message 信息
     * @return Result
     */
    public Result message(String message){
        this.setMessage(message);
        return this;
    }

    /**
     * 创建方法，返回结果信息
     * @param code 状态码
     * @return Result
     */
    public Result code(Integer code){
        this.setCode(code);
        return this;
    }

    /**
     * 创建方法，返回结果数据
     * @param map 键值对
     * @return Result
     */

    public Result data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}
