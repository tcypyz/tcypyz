package com.example.smserver.core.base;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.toolkit.SimpleQuery;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/28
 */
public interface BaseService<M extends BaseMapper<T>, T> extends IService<T> {

    /**
     * 获取baseMapper
     *
     * @return {@link M}
     */
    @Override
    M getBaseMapper();

    /**
     * 查询列表
     *
     * @param wrapper   lambda的条件构造器
     * @param sFunction list中的元素
     * @return {@link List}<{@link A}>
     */
    default <A> List<A> simpleList(LambdaQueryWrapper<T> wrapper, SFunction<T, A> sFunction) {
        return SimpleQuery.list(wrapper, sFunction);
    }

    /**
     * 键映射表
     *
     * @param wrapper   lambda的条件构造器
     * @param sFunction 实体中属性的getter,用于封装后map中作为key的条件
     * @return {@link Map}<{@link A}, {@link T}>
     */
    default <A> Map<A, T> simpleKeyMap(LambdaQueryWrapper<T> wrapper, SFunction<T, A> sFunction) {
        return SimpleQuery.keyMap(wrapper, sFunction);
    }

    /**
     * map
     *
     * @param wrapper   lambda的条件构造器
     * @param keyFunc   封装后map中作为key的条件
     * @param valueFunc 封装后map中作为value的条件
     * @return {@link Map}<{@link A}, {@link P}>
     */
    default <A, P> Map<A, P> simpleMap(LambdaQueryWrapper<T> wrapper, SFunction<T, A> keyFunc, SFunction<T, P> valueFunc) {
        return SimpleQuery.map(wrapper, keyFunc, valueFunc);
    }

}
