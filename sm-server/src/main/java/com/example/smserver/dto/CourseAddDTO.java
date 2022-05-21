package com.example.smserver.dto;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@ToString
public class CourseAddDTO {
    private String className;
    private long openUserId;
    private Integer status;
    private String academic;
    private LocalDateTime createTime;
    private Date endTime;
    private Integer count;
}
