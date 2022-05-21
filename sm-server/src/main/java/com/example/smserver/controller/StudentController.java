package com.example.smserver.controller;

import com.example.smserver.api.service.MemberService;
import com.example.smserver.core.base.BaseController;
import com.example.smserver.core.base.BaseDTO;
import com.example.smserver.core.context.LoginContexts;
import com.example.smserver.core.result.Result;
import com.example.smserver.core.result.ResultCode;
import com.example.smserver.core.result.ResultFactory;
import com.example.smserver.service.TeacherService;
import com.example.smserver.vo.StudentTableVO;
import com.example.smserver.vo.TeacherTableVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/28
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private MemberService memberService;

    @PostMapping(value = "/list")
    public Result<List<StudentTableVO>> list(){
        List<StudentTableVO> studentTableVoList = memberService.getstuPage();
        return ResultFactory.buildSuccessResult(studentTableVoList);
    }


}
