package com.example.smserver.dto;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author wlt
 */
@Data
public class CourseAddDTO {
    private String className;
    private Long openUserId;
    private Integer status;
    private String academic;
    private LocalDateTime createTime;
    private Date endTime;
    private Integer count;
}
