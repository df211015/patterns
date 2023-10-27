package com.dfliu.patterns.domain.constants;


/**
 * 响应码枚举，参考HTTP状态码的语义
 */
public enum ResultCode {
    SUCCESSEXT(0, "成功"),
    FAIL(400, "失败"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    ;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private final Integer code;
    private final String message;

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}
