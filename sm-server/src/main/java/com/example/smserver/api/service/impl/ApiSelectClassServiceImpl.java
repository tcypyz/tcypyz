package com.example.smserver.api.service.impl;

import com.example.smserver.api.service.ApiSelectClassService;
import com.example.smserver.converter.SelectClassVoConverter;
import com.example.smserver.entity.Course;
import com.example.smserver.entity.SelectClass;
import com.example.smserver.service.CourseService;
import com.example.smserver.service.SelectClassService;
import com.example.smserver.service.UserService;
import com.example.smserver.vo.SelectClassVO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApiSelectClassServiceImpl implements ApiSelectClassService {

    @Autowired
    private SelectClassService selectClassService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @Override
    public int addCourseStudent(Long courseId, Long studentId) {
        return selectClassService.getBaseMapper().addCourseStudent(courseId, studentId);
    }

    @Override
    public int deleteCourseStudent(Long courseId, Long studentId) {
        return selectClassService.getBaseMapper().deleteCourseStudent(courseId, studentId);
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
        if(CollectionUtils.isEmpty(courseIdList)){
            return new ArrayList<>();
        }
        List<Course> courseList = courseService.lambdaQuery().in(Course::getId, courseIdList).list();

        List<SelectClassVO> selectClassVOList = SelectClassVoConverter.INSTANCE.toDataList(courseList);
        selectClassVOList.forEach(item -> item.setTeacherName(userService.getById(item.getOpenUserId()).getName()));
        return selectClassVOList;
    }
}
