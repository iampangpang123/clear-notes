package com.example.clear.notes.common.exception;

/**
 * @author 唐涛
 * @description: TODO
 * @date 2021/5/8
 */
public class BeanUtilsException extends RuntimeException {

    public BeanUtilsException(String message) {
        super(message);
    }

    public BeanUtilsException(String message, Throwable cause) {
        super(message, cause);
    }
}

