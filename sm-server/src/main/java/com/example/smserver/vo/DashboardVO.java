package com.example.smserver.vo;

import com.example.smserver.core.context.DigitalContexts;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2022/5/14
 */
@Data
@AllArgsConstructor
@Builder
public class DashboardVO implements Serializable {
    private Integer select;
    private Integer score;
    private List<CourseListVO> courseList;
    private List<String> xAxis;
    private List<Integer> series;

    public DashboardVO() {
        this.courseList = new ArrayList<>();
        this.series = new ArrayList<>();
        this.xAxis = new ArrayList<>();
        this.select = DigitalContexts.ZERO;
        this.score = DigitalContexts.ZERO;
    }
}
