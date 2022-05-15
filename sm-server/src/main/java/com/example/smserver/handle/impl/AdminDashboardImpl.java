package com.example.smserver.handle.impl;

import com.example.smserver.core.context.DigitalContexts;
import com.example.smserver.entity.User;
import com.example.smserver.handle.DashboardHandle;
import com.example.smserver.type.RoleEnum;
import com.example.smserver.vo.DashboardVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @description:
 * @author: zhh
 * @time: 2022/5/14
 */
@Service
public class AdminDashboardImpl implements DashboardHandle {

    @Override
    public DashboardVO process(User user) {
        return new DashboardVO();
    }

    @Override
    public RoleEnum getType() {
        return RoleEnum.ADMIN;
    }
}
