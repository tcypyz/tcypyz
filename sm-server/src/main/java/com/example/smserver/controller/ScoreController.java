package com.example.smserver.controller;

import com.example.smserver.api.service.ScoreInfoService;
import com.example.smserver.core.base.BaseController;
import com.example.smserver.core.result.Result;
import com.example.smserver.core.result.ResultFactory;
import com.example.smserver.dto.StudentScoreDTO;
import com.example.smserver.vo.ScoreTableVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2022/5/23
 */
@RestController
@Slf4j
@RequestMapping("/score")
public class ScoreController extends BaseController {

    @Autowired
    private ScoreInfoService scoreInfoService;

    @PostMapping("/student/query")
    public Result<List<ScoreTableVO>> queryStudent(@RequestBody StudentScoreDTO dto){
        return ResultFactory.buildSuccessResult(scoreInfoService.queryStudent(dto, 2L));
    }
}
