package com.example.smserver.controller;

import com.example.smserver.core.result.Result;
import com.example.smserver.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/14
 */
@RestController
@RequestMapping("/sys")
public class SystemController {

    @Autowired
    private TestService testService;

    @PostMapping("/test")
    public Result test() throws Exception {
        return new Result(404, "", testService.list());
    }
}
