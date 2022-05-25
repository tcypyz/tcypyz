package com.example.smserver.controller;

import com.example.smserver.api.service.MemberService;
import com.example.smserver.core.result.Result;
import com.example.smserver.core.result.ResultFactory;
import com.example.smserver.vo.StudentTableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
