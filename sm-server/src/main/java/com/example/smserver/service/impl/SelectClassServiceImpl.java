package com.example.smserver.service.impl;

import com.example.smserver.core.base.entity.BaseEntityServiceImpl;
import com.example.smserver.entity.SelectClass;
import com.example.smserver.mapper.SelectClassMapper;
import com.example.smserver.service.SelectClassService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/12
 */
@Service
public class SelectClassServiceImpl extends BaseEntityServiceImpl<SelectClassMapper, SelectClass> implements SelectClassService {
}
