package com.example.smserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.smserver.entity.Course;
import com.example.smserver.mapper.CourseMapper;
import com.example.smserver.service.CourseService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/12
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
}
