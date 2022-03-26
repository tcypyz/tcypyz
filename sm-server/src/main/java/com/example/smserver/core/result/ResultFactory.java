package com.example.smserver.core.result;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/26
 */
public class ResultFactory {

    public static Result<String> buildSuccessResult() {
        return buildSuccessResult("");
    }

    public static <T> Result<T> buildSuccessResult(T data) {
        return buildResult(ResultCode.SUCCESS, "success", data);
    }

    public static Result<String> buildFailResult(String message) {
        return buildResult(ResultCode.FAIL, message, "");
    }

    public static <T> Result<T> buildResult(ResultCode resultCode, String message, T data) {
        return buildResult(resultCode.code, message, data);
    }

    public static <T> Result<T> buildResult(ResultCode resultCode, ResultCode msg, T data) {
        return buildResult(resultCode.code, msg.data, data);
    }

    public static Result<String> buildResult(ResultCode resultCode,  ResultCode msg) {
        return buildResult(resultCode, msg.data);
    }

    public static Result<String> buildResult(ResultCode resultCode, String message) {
        return buildResult(resultCode, message, "");
    }

    public static <T> Result<T> buildResult(int resultCode, String message, T data) {
        return new Result<>(resultCode, message, data);
    }
}
