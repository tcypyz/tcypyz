package com.example.smserver.controller;

import com.example.smserver.core.context.LoginContexts;
import com.example.smserver.core.result.Result;
import com.example.smserver.core.result.ResultCode;
import com.example.smserver.core.result.ResultFactory;
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
    @RequestMapping("/filter")
    public Result<String> handleError(){
        return ResultFactory.buildResult(ResultCode.SUCCESS, LoginContexts.TOKEN_ERROR);
    }
}
