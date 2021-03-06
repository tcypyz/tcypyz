package com.example.smserver.service.impl;

import com.example.smserver.core.base.entity.BaseEntityServiceImpl;
import com.example.smserver.entity.Role;
import com.example.smserver.mapper.RoleMapper;
import com.example.smserver.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/28
 */
@Service
public class RoleServiceImpl extends BaseEntityServiceImpl<RoleMapper, Role> implements RoleService {
}
