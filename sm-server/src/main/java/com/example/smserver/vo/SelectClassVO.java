package com.example.smserver.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class SelectClassVO implements Serializable {

    private String className;
    private Long openUserId;
    private String teacherName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime endTime;
    private String academic;

}
