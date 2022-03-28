package com.example.smserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.smserver.entity.User;
import com.example.smserver.mapper.UserMapper;
import com.example.smserver.service.UserServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/28
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> implements UserServiceImpl {
}
