package com.example.clear.notes.common.result;

import lombok.Data;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/5/8
 */
@Data
public class Result {
    private int code;
    private String message;
    private Object result;

    Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.result = data;
    }
    public static Result buildSuccessResult(Object data) {
        return buildResult(ResultCode.SUCCESS, "成功", data);
    }

    public static Result buildFailResult(String message) {
        return buildResult(ResultCode.FAIL, message, null);
    }

    public static Result buildResult(ResultCode resultCode, String message, Object data) {
        return buildResult(resultCode.code, message, data);
    }

    public static Result buildResult(int resultCode, String message, Object data) {
        return new Result(resultCode, message, data);
    }

}
