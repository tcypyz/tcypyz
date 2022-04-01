package com.example.smserver.core;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/28
 */
public class CustomException extends RuntimeException {

    public CustomException(String msg){
        super(msg);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }
    public CustomException() {
        super();
    }
}
