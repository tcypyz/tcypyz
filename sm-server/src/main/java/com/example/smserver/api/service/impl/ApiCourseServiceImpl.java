package com.example.smserver.api.service.impl;

import com.example.smserver.api.service.ApiCourseService;
import com.example.smserver.converter.CourseVoConverter;
import com.example.smserver.dto.CourseDTO;
import com.example.smserver.entity.Course;
import com.example.smserver.service.CourseService;
import com.example.smserver.service.UserService;
import com.example.smserver.vo.CourseVO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApiCourseServiceImpl implements ApiCourseService {

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @Override
    public List<CourseVO> selectCourseTeacher(Long teacherId) {
        List<Course> courseList = courseService.lambdaQuery()
                .eq(Course::getOpenUserId, teacherId)
                .list();
        if(CollectionUtils.isEmpty(courseList)){
            return new ArrayList<>();
        }
        List<CourseVO> courseVOList = CourseVoConverter.INSTANCE.toDataList(courseList);
        courseVOList.forEach(item -> item.setTeacherName(userService.getById(item.getOpenUserId()).getName()));
        return courseVOList;
    }

    @Override
    public void addCourseTeacher(CourseDTO courseDTO) {
        if (courseDTO.getCreateTime() == null) {
            courseDTO.setCreateTime(LocalDateTime.now());
        }
        courseService.getBaseMapper().addCourseTeacher(courseDTO);
    }

    @Override
    public void deleteCourseTeacher(Long courseId) {
        Course course = courseService.lambdaQuery()
                .eq(Course::getId, courseId).getEntity();
        if(!ObjectUtils.isEmpty(course)) {
            courseService.getBaseMapper().deleteCourseTeacher(courseId);
        }
    }

    @Override
    public void updateCourseTeacher(CourseDTO courseDTO) {
        if(!ObjectUtils.isEmpty(courseDTO)) {
            courseService.getBaseMapper().updateCourseTeacher(courseDTO);
        }
    }
}
