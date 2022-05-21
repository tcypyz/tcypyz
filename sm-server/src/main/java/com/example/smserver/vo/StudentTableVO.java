package com.example.smserver.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @description:
 * @author: wyx
 * @time: 2022/4/26
 */

@Data
@ToString
public class StudentTableVO implements Serializable {
    private Long userId;
    private String name;
    private Integer sex;
    private String phone;
    private String college;
    private String profession;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime inTime;
}
