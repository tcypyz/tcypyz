package com.example.smserver.api.service;

import com.example.smserver.dto.CourseDTO;
import com.example.smserver.vo.CourseVO;

import java.util.List;

public interface ApiCourseService {

    List<CourseVO> selectCourseTeacher(Long teacherId);

    void addCourseTeacher(CourseDTO courseDTO);

    void deleteCourseTeacher(Long courseId);

    void updateCourseTeacher(CourseDTO courseDTO);

}
