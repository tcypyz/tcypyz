package com.example.smserver.dto;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class CourseDTO {
    private Long id;
    private String className;
    private String academic;
    private LocalDateTime createTime;
    private LocalDateTime endTime;
    private Integer countNum;
    private Long openUserId;
    private int status;

}
