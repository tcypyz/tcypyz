package com.example.smserver.handle;

import com.example.smserver.core.base.HandleType;
import com.example.smserver.type.RoleEnum;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/21
 */
public interface AccountHandle<T> extends HandleType<RoleEnum> {

    /**
     * 执行
     *
     * @param account 账户
     * @param userId  用户id
     */
    void process(T account, Long userId);

    /**
     * 类型
     *
     * @return {@link RoleEnum}
     */
    @Override
    RoleEnum getType();

}
