package com.example.smserver.api.service.impl;

import com.example.smserver.api.service.ApiSelectClassService;
import com.example.smserver.service.SelectClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiSelectClassServiceImpl implements ApiSelectClassService {

    @Autowired
    private SelectClassService selectClassService;

    @Override
    public int addCourseStudent(Long courseId, Long studentId) {
        return selectClassService.getBaseMapper().addCourseStudent(courseId, studentId);
    }

    @Override
    public int deleteCourseStudent(Long courseId, Long studentId) {
        return selectClassService.getBaseMapper().deleteCourseStudent(courseId, studentId);
    }
}
