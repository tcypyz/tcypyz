package com.example.smserver.controller;

import com.example.smserver.api.service.ApiSelectClassService;
import com.example.smserver.core.base.BaseController;
import com.example.smserver.core.result.Result;
import com.example.smserver.core.result.ResultFactory;
import com.example.smserver.dto.IdDTO;
import com.example.smserver.vo.EnableScheduleVO;
import com.example.smserver.vo.SelectClassVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wlt
 */
@RestController
@RequestMapping("/select/course")
public class SelectClassController extends BaseController {


    @Autowired
    private ApiSelectClassService apiSelectClassService;

    @PostMapping("/add")
    @ApiOperation("学生选课")
    public Result<String> addCourseStudent(@RequestBody IdDTO dto) {
        apiSelectClassService.addSelect(dto);
        return ResultFactory.buildSuccessResult();
    }

    @GetMapping(value = "/enable/schedule")
    @ApiOperation("获取学生可选的课程列表")
    public Result<List<EnableScheduleVO>> getSchedule() {
        List<EnableScheduleVO> res = apiSelectClassService.getEnableSchedule(getUserId());
        return ResultFactory.buildSuccessResult(res);
    }

    @GetMapping("/studentSelected")
    @ApiOperation("获取学生已经选的课表")
    public Result<List<SelectClassVO>> selectCourseStudent() {
        Long id = getUserId();
        List<SelectClassVO> selectClassVoS = apiSelectClassService.selectCourseStudent(id);
        return ResultFactory.buildSuccessResult(selectClassVoS);
    }
}
