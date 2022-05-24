package com.example.smserver.core.base;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SimpleQuery;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/28
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<M, T>{

    @Override
    public M getBaseMapper() {
        return super.getBaseMapper();
    }

    @Override
    public LambdaQueryWrapper<T> lambdaWrapper() {
        return new LambdaQueryWrapper<>();
    }

}
