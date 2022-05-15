package com.example.smserver.handle;

import com.example.smserver.core.base.HandleType;
import com.example.smserver.entity.User;
import com.example.smserver.type.RoleEnum;
import com.example.smserver.vo.DashboardVO;

/**
 * @description:
 * @author: zhh
 * @time: 2022/5/14
 */
public interface DashboardHandle extends HandleType<RoleEnum> {

    /**
     * 过程
     *
     * @return {@link DashboardVO}
     */
    DashboardVO process(User user);

    /**
     * 得到类型
     *
     * @return {@link RoleEnum}
     */
    @Override
    RoleEnum getType();
}
