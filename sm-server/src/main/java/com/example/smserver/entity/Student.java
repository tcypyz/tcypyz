package com.example.smserver.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/7
 */
@Data
@TableName("sms_student")
public class Student implements Serializable {
    @TableId
    private Long id;
    private Long userId;
    private String college;
    private String profession;
    private LocalDateTime inTime;

}
