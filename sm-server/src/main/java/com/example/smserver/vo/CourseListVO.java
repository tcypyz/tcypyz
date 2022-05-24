package com.example.smserver.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @description:
 * @author: zhh
 * @time: 2022/5/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseListVO implements Serializable {
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime endTime;
    private String teacher;
    private String academic;
    private Long openUserId;
}
