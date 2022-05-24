package com.example.smserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * @description:
 * @author: zhh
 * @time: 2022/4/7
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sms_teacher")
public class Teacher implements Serializable {
    @TableId
    private Long id;
    private Long userId;
    private String college;
    private String occupation;
    private LocalDateTime inTime;
}
