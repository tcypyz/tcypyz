package com.example.smserver.core.result;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/26
 */
public enum ResultCode {
    /**
     * 404 未找到接口
     */
    NOT_FOUND(404, "接口未找到"),

    /**
     * 200 成功
     */
    SUCCESS(200, ""),

    FAIL(400, "请求失败"),

    FORBIDDEN(403, "禁止访问"),

    /**
     * 401未认证
     */
    UNAUTHORIZED(401, "权限认证失败"),

    /**
     * 服务器内部错误
     */
    INTERNAL_SERVER_ERROR(500, "服务器内部异常");

    public int code;
    public String data;

    ResultCode(int code, String data) {
        this.code = code;
        this.data = data;
    }
}
