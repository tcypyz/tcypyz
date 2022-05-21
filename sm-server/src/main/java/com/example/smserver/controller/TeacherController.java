package com.example.smserver.controller;

import com.example.smserver.api.service.MemberService;
import com.example.smserver.core.base.BaseController;
import com.example.smserver.core.base.BaseDTO;
import com.example.smserver.core.result.Result;
import com.example.smserver.core.result.ResultFactory;
import com.example.smserver.vo.TeacherTableVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: wyx
 * @time: 2022/4/22
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController extends BaseController {

    @Autowired
    private MemberService memberService;

    @PostMapping(value = "/list")
    public Result<PageInfo<TeacherTableVO>> list(@RequestBody BaseDTO dto){
        PageInfo<TeacherTableVO> pageInfo = memberService.getPage(dto);
        return ResultFactory.buildSuccessResult(pageInfo);
    }
}
