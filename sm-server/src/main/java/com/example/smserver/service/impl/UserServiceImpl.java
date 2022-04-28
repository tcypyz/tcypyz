package com.example.smserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.smserver.core.base.BaseServiceImpl;
import com.example.smserver.entity.User;
import com.example.smserver.mapper.UserMapper;
import com.example.smserver.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/28
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {

}
