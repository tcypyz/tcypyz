package com.example.smserver.controller;

import com.example.smserver.api.service.ApiSelectClassService;
import com.example.smserver.core.base.BaseController;
import com.example.smserver.core.result.Result;
import com.example.smserver.core.result.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/selectCourse")
public class SelectClassController extends BaseController {

    @Autowired
    private ApiSelectClassService selectClassService;

    @PostMapping("/studentAddCourse")
    public Result<Integer> addCourseStudent(Long courseId, Long studentId) {
        int n = selectClassService.addCourseStudent(courseId, studentId);
        return ResultFactory.buildSuccessResult(1);
    }

    @PostMapping("/studentDeleteCourse")
    public Result<Integer> deleteCourseStudent(Long courseId, Long studentId) {
        int n = selectClassService.deleteCourseStudent(courseId, studentId);
        return ResultFactory.buildSuccessResult(1);
    }
}
