package com.example.smserver.api.service;

import com.example.smserver.dto.StudentScoreDTO;
import com.example.smserver.vo.ScoreTableVO;

import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2022/5/23
 */
public interface ScoreInfoService {

    /**
     * 查询学生选课成绩
     *
     * @param dto       dto
     * @param studentId 学生id
     * @return {@link List}<{@link ScoreTableVO}>
     */
    List<ScoreTableVO> queryStudent(StudentScoreDTO dto, Long studentId);
}
