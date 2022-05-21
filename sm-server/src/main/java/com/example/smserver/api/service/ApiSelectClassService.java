package com.example.smserver.api.service;

import com.example.smserver.vo.SelectClassVO;

import java.util.List;

public interface ApiSelectClassService {

    int addCourseStudent(Long courseId, Long studentId);

    int deleteCourseStudent(Long courseId, Long studentId);

    List<SelectClassVO> selectCourseStudent(Long studentId);
}
