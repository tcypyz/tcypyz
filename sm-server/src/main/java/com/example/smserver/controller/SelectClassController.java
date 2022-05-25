package com.example.smserver.controller;

import com.example.smserver.api.service.ApiSelectClassService;
import com.example.smserver.core.base.BaseController;
import com.example.smserver.core.result.Result;
import com.example.smserver.core.result.ResultFactory;
import com.example.smserver.vo.EnableScheduleVO;
import com.example.smserver.vo.SelectClassVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wlt
 */
@RestController
@RequestMapping("/select/course")
public class SelectClassController extends BaseController {


    @Autowired
    private ApiSelectClassService apiSelectClassService;

    @PostMapping("/studentAddCourse")
    public Result<String> addCourseStudent(Long courseId, Long studentId) {
        apiSelectClassService.addCourseStudent(courseId, studentId);
        return ResultFactory.buildSuccessResult();
    }

    @GetMapping(value = "/enable/schedule")
    public Result<List<EnableScheduleVO>> getSchedule() {
        List<EnableScheduleVO> res = apiSelectClassService.getEnableSchedule(2L);
        return ResultFactory.buildSuccessResult(res);
    }

    @GetMapping("/studentSelected")
    public Result<List<SelectClassVO>> selectCourseStudent() {
        Long id = getUserId();
        List<SelectClassVO> selectClassVoS = apiSelectClassService.selectCourseStudent(id);
        return ResultFactory.buildSuccessResult(selectClassVoS);
    }
}
