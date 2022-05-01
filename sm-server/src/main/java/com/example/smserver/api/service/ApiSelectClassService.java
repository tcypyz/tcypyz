package com.example.smserver.api.service;

public interface ApiSelectClassService {

    int addCourseStudent(Long courseId, Long studentId);

    int deleteCourseStudent(Long courseId, Long studentId);
}
