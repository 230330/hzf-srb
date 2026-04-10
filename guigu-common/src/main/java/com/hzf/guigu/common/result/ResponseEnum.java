package com.hzf.guigu.common.result;

import com.sun.deploy.net.DownloadException;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ResponseEnum {
    SUCCESS(0, "成功"),
    ERROR(-1, "服务器内部错误"),

    //-1xx 服务器错误
    BAD_SQL_GRAMMAR_ERROR(-101, "sql语法错误"),
    SERVLET_ERROR(-102, "servlet请求异常"), 
    UPLOAD_ERROR(-103, "文件上传错误"),
    EXPORT_DATA_ERROR(104, "数据导出失败"),


    //-2xx 参数校验
    INTEGRAL_START_NULL_ERROR(-200, "积分区间开始不能为空"),
    INTEGRAL_END_NULL_ERROR(-201, "积分区间结束不能为空"),
    BORROW_AMOUNT_NULL_ERROR(-202, "借款额度不能为空"),
    BORROW_USER_ID_NULL_ERROR(-203, "用户ID不能为空"),
    MOBILE_NULL_ERROR(-204, "手机号码不能为空"),
    MOBILE_ERROR(-205, "手机号码不正确"),
    PASSWORD_NULL_ERROR(-206, "密码不能为空"),
    CODE_NULL_ERROR(-207, "验证码不能为空"),
    CODE_ERROR(-208, "验证码错误"),
    MOBILE_EXIST_ERROR(-209, "手机号已被注册"),
    LOGIN_MOBILE_ERROR(-210, "用户不存在"),
    LOGIN_PASSWORD_ERROR(-2211, "密码错误"),
    LOGIN_LOKED_ERROR(-212, "用户被锁定"),
    LOGIN_AUTH_ERROR(-213, "未登录"),
    ID_CARD_NULL_ERROR(-214, "身份证号码不能为空"),
    NAME_NULL_ERROR(-215, "姓名不能为空"),
    BORROW_PERIOD_NULL_ERROR(-216, "借款期限不能为空"),
    BORROW_BORROW_YEAR_RATE_NULL_ERROR(-217, "借款年利率不能为空"),
    BORROW_RETURN_METHOD_NULL_ERROR(-218, "还款方式不能为空"),


    USER_BIND_IDCARD_EXIST_ERROR(-301, "身份证号码已绑定"),
    USER_NO_BIND_ERROR(302, "用户未绑定"),
    USER_NO_AMOUNT_ERROR(303, "用户信息未审核"),
    USER_AMOUNT_LESS_ERROR(304, "您的借款额度不足"),
    LEND_INVEST_ERROR(305, "当前状态无法投标"),
    LEND_FULL_SCALE_ERROR(306, "已满标，无法投标"),
    NOT_SUFFICIENT_FUNDS_ERROR(307, "余额不足，请充值"),

    PAY_UNIFIEDORDER_ERROR(401, "统一下单错误"),

    //业务限流
    ALIYUN_SMS_LIMIT_CONTROL_ERROR(-502, "短信发送过于频繁"),
    //其他失败
    ALIYUN_SMS_ERROR(-503, "短信发送失败"),

    WEIXIN_CALLBACK_PARAM_ERROR(-601, "回调参数不正确"),
    WEIXIN_FETCH_ACCESSTOKEN_ERROR(-602, "获取access_token失败"),
    WEIXIN_FETCH_USERINFO_ERROR(-603, "获取用户信息失败"),;


    private final Integer code;
    private final String message;
   /**
     * 私有构造函数，防止外部实例化
     *
     * @param code    状态码
     * @param message 状态码对应的描述信息
     */
    ResponseEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
