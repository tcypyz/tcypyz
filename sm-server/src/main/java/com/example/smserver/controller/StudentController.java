package com.example.smserver.controller;

import com.example.smserver.core.context.LoginContexts;
import com.example.smserver.core.result.Result;
import com.example.smserver.core.result.ResultCode;
import com.example.smserver.core.result.ResultFactory;
import com.example.smserver.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/28
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/filter")
    public Result<String> handleError(){
        System.out.println(teacherService.getBaseMapper().getTchByNo(1515337023803723778L));
        return ResultFactory.buildResult(ResultCode.SUCCESS, LoginContexts.TOKEN_ERROR);
    }
}
