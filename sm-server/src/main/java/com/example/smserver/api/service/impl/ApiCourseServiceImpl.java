package com.example.smserver.api.service.impl;

import com.example.smserver.api.service.ApiCourseService;
import com.example.smserver.converter.CourseVoConverter;
import com.example.smserver.dto.CourseDTO;
import com.example.smserver.entity.Course;
import com.example.smserver.entity.SelectClass;
import com.example.smserver.service.CourseService;
import com.example.smserver.service.SelectClassService;
import com.example.smserver.service.UserService;
import com.example.smserver.vo.CourseVO;
import com.example.smserver.vo.SelectClassVO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApiCourseServiceImpl implements ApiCourseService {

    @Autowired
    private CourseService courseService;

    @Autowired
    private SelectClassService selectClassService;

    @Autowired
    private UserService userService;

    @Override
    public List<CourseVO> selectAllCourse() {
        return courseService.getBaseMapper().selectAllCourse();
    }

    @Override
    public int addCourseTeacher(CourseDTO courseDTO) {
        return courseService.getBaseMapper().addCourseTeacher(courseDTO);
    }

    @Override
    public int deleteCourseTeacher(Long courseId) {
        return courseService.getBaseMapper().deleteCourseTeacher(courseId);
    }

    @Override
    public List<SelectClassVO> selectCourseStudent(Long studentId) {
        List<Long> courseIdList = selectClassService
                .lambdaQuery()
                .eq(SelectClass::getStudentId, studentId)
                .list()
                .stream()
                .map(SelectClass::getClassId)
                .collect(Collectors.toList());
        // return courseService.getBaseMapper().selectCourseStudent(courseIdList);
        List<Course> courseList = courseService.lambdaQuery().in(CollectionUtils.isNotEmpty(courseIdList), Course::getId, courseIdList).list();

        List<SelectClassVO> selectClassVOList = CourseVoConverter.INSTANCE.toDataList(courseList);
        selectClassVOList.forEach(item -> {
            item.setTeacherName(userService.getById(item.getOpenUserId()).getName());
        });

        return selectClassVOList;
    }
}
