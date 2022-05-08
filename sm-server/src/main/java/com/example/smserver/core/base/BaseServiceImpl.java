package com.example.smserver.core.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

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
}