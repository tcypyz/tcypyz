package com.example.smserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.smserver.entity.Teacher;
import com.example.smserver.mapper.TeacherMapper;
import com.example.smserver.service.TeacherService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/7
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
}
