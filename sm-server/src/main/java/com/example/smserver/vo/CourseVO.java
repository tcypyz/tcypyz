package com.example.smserver.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CourseVO implements Serializable {

    private Long id;
    private String academic;
    private String className;
    private Long openUserId;
    private String teacherName;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime endTime;
    private Integer countNum;
    private Integer unselected;

}
