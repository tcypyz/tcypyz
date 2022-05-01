package com.example.smserver.api.service;

import com.example.smserver.dto.CourseDTO;
import com.example.smserver.vo.CourseVO;
import com.example.smserver.vo.SelectClassVO;

import java.util.List;

public interface ApiCourseService {

    List<CourseVO> selectAllCourse();

    int addCourseTeacher(CourseDTO courseDTO);

    int deleteCourseTeacher(Long courseId);

    List<SelectClassVO> selectCourseStudent(Long studentId);

}
