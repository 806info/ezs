package com.gpt806.ezs.common;

import lombok.Getter;

/**
 * @author: zzx
 * @date: 2018/10/15 15:16
 * @description: 返回的错误码枚举类
 */
@Getter
public enum ResultEnum {

    SUCCESS(0,"OK"),
    FAILURE(-1,"FAIL"),
    PARAM_ERROR(40000,"参数错误"),
    USER_NEED_AUTHORITIES(40001,"用户未登录"),
    USER_LOGIN_FAILED(40002,"用户账号或密码错误"),
    USER_NO_ACCESS(40003,"用户无权访问"),
    TOKEN_IS_BLACKLIST(40004,"此token为黑名单"),
    LOGIN_IS_OVERDUE(40005,"登录已失效"),
    NO_TOKEN(40006,"没有传递token"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * @author: zzx
     * @date: 2018-10-15 16:26
     * @deprecation:通过code返回枚举
     */
    public static ResultEnum parse(int code){
        ResultEnum[] values = values();
        for (ResultEnum value : values) {
            if(value.getCode() == code){
                return value;
            }
        }
        throw  new RuntimeException("Unknown code of ResultEnum");
    }
}