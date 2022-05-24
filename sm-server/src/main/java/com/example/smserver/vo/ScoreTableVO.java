package com.example.smserver.vo;

import lombok.Data;

/**
 * @description:
 * @author: zhh
 * @time: 2022/5/23
 */
@Data
public class ScoreTableVO {
    private Long classId;
    private String className;
    private String teacher;
    private Integer common;
    private Integer finalExam;
    private Integer result;
}
