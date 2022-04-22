package com.example.smserver.core.base;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/22
 */
public interface HandleType<T> {

    /**
     * 类型
     *
     * @return {@link T}
     */
    T getType();
}
