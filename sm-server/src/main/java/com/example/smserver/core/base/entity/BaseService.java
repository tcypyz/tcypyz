package com.example.smserver.core.base.entity;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import java.io.Serializable;

/**
 * @description:
 * @author: zhh
 * @time: 2022/5/25
 */
public interface BaseService {

    /**
     * lambda的条件构造器
     *
     * @param c c
     * @return {@link LambdaQueryWrapper}<{@link T}>
     */
    default <T extends Serializable> LambdaQueryWrapper<T> lambdaWrapper(Class<T> c){
         return new LambdaQueryWrapper<>(c);
     };
}
