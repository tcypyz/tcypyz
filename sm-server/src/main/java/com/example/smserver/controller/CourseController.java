package com.example.smserver.controller;

import com.example.smserver.api.service.ApiCourseService;
import com.example.smserver.core.base.BaseController;
import com.example.smserver.core.result.Result;
import com.example.smserver.core.result.ResultFactory;
import com.example.smserver.dto.CourseDTO;
import com.example.smserver.vo.CourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController extends BaseController {

    @Autowired
    private ApiCourseService apiCourseService;

    @GetMapping("/teacherSelectClass")
    public Result<List<CourseVO>> selectCourseTeacher() {
        List<CourseVO> courseVOList = apiCourseService.selectCourseTeacher(getUserId());
        return ResultFactory.buildSuccessResult(courseVOList);
    }

    @PostMapping("/teacherOpenClass")
    public Result<String> addCourseTeacher(@RequestBody CourseDTO courseDTO) {
        courseDTO.setOpenUserId(getUserId());
        apiCourseService.addCourseTeacher(courseDTO);
        return ResultFactory.buildSuccessResult();
    }

    @PostMapping("/teacherDeleteClass")
    public Result<String> deleteCourseTeacher(Long courseId) {
        apiCourseService.deleteCourseTeacher(courseId);
        return ResultFactory.buildSuccessResult();
    }

}
