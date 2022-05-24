package com.example.smserver.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/22
 */
@Data
public class TeacherTableVO implements Serializable {
    private Long userId;
    private String name;
    private Integer sex;
    private String phone;
    private String occupation;
    private String college;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime inTime;
}
