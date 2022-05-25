package com.example.smserver.service.impl;

import com.example.smserver.core.base.entity.BaseEntityServiceImpl;
import com.example.smserver.entity.Menu;
import com.example.smserver.mapper.MenuMapper;
import com.example.smserver.service.MenuService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/4
 */
@Service
public class MenuServiceImpl extends BaseEntityServiceImpl<MenuMapper, Menu> implements MenuService {
}
