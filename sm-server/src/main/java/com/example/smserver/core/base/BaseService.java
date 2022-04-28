package com.example.smserver.core.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
