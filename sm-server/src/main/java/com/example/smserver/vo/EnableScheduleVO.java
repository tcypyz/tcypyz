package com.example.smserver.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @description:
 * @author: zhh
 * @time: 2022/5/25
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class EnableScheduleVO extends CourseListVO implements Serializable {
    private String time;
    private Integer status;

}
