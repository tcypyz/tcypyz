package com.example.smserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.smserver.core.base.BaseDTO;
import com.example.smserver.core.base.BaseService;
import com.example.smserver.dto.IdDTO;
import com.example.smserver.dto.UserAddDTO;
import com.example.smserver.dto.UserEditDTO;
import com.example.smserver.entity.User;
import com.example.smserver.mapper.UserMapper;
import com.example.smserver.vo.MenuVO;
import com.example.smserver.vo.UserTableVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/28
 */
public interface UserService extends BaseService<UserMapper, User> {

}
