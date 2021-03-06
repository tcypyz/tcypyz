package com.example.smserver.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author wlt
 */
@Data
public class CourseDTO {

    private Long id;
    private String className;
    private String academic;
    private LocalDateTime createTime;
    private LocalDateTime endTime;
    private Integer countNum;
    private Long openUserId;
    private Integer status;

}
