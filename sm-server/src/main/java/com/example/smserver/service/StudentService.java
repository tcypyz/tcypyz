package com.example.smserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.smserver.core.base.BaseService;
import com.example.smserver.entity.Student;
import com.example.smserver.mapper.StudentMapper;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/7
 */
public interface StudentService extends BaseService<StudentMapper,Student> {
}
