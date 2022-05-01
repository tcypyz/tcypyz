package com.example.smserver.controller;

import com.example.smserver.api.service.ApiCourseService;
import com.example.smserver.core.base.BaseController;
import com.example.smserver.core.result.Result;
import com.example.smserver.core.result.ResultFactory;
import com.example.smserver.dto.CourseDTO;
import com.example.smserver.vo.CourseVO;
import com.example.smserver.vo.SelectClassVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController extends BaseController {

    @Autowired
    private ApiCourseService apiCourseService;

    @GetMapping("/allCourse")
    public Result<List<CourseVO>> selectAllCourse() {
        List<CourseVO> courseVOS = apiCourseService.selectAllCourse();
        return ResultFactory.buildSuccessResult(courseVOS);
    }

    @PostMapping("/teacherOpenClass")
    public Result<String> addCourseTeacher(CourseDTO courseDTO) {
        apiCourseService.addCourseTeacher(courseDTO);
        return ResultFactory.buildSuccessResult();
    }

    @PostMapping("/teacherDeleteClass")
    public Result<String> deleteCourseTeacher(Long courseId) {
        apiCourseService.deleteCourseTeacher(courseId);
        return ResultFactory.buildSuccessResult();
    }

    @GetMapping("/studentSelected")
    public Result<List<SelectClassVO>> selectCourseStudent() {
        Long id = getUserId();
        List<SelectClassVO> selectClassVOS = apiCourseService.selectCourseStudent(id);
        return ResultFactory.buildSuccessResult(selectClassVOS);
    }
}
