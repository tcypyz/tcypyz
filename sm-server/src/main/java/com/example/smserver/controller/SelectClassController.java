package com.example.smserver.controller;

import com.example.smserver.api.service.ApiSelectClassService;
import com.example.smserver.core.base.BaseController;
import com.example.smserver.core.result.Result;
import com.example.smserver.core.result.ResultFactory;
import com.example.smserver.vo.SelectClassVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/selectCourse")
public class SelectClassController extends BaseController {

    @Autowired
    private ApiSelectClassService selectClassService;

    @Autowired
    private ApiSelectClassService apiSelectClassService;

    @PostMapping("/studentAddCourse")
    public Result<Integer> addCourseStudent(Long courseId, Long studentId) {
        selectClassService.addCourseStudent(courseId, studentId);
        return ResultFactory.buildSuccessResult(1);
    }

    @PostMapping("/studentDeleteCourse")
    public Result<Integer> deleteCourseStudent(Long courseId, Long studentId) {
        selectClassService.deleteCourseStudent(courseId, studentId);
        return ResultFactory.buildSuccessResult(1);
    }

    @GetMapping("/studentSelected")
    public Result<List<SelectClassVO>> selectCourseStudent() {
        Long id = getUserId();
        List<SelectClassVO> selectClassVOS = apiSelectClassService.selectCourseStudent(id);
        return ResultFactory.buildSuccessResult(selectClassVOS);
    }
}
