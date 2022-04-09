package com.example.smserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.smserver.entity.Student;
import com.example.smserver.mapper.StudentMapper;
import com.example.smserver.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/7
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
}
