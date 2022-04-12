package com.example.smserver.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/12
 */
@Data
@ToString
@TableName("sms_score")
public class Score implements Serializable {
    @TableId
    private Long id;
    private Long studentId;
    private Long classId;
    private Integer result;
    private Integer usual;
    private Integer finalExam;
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}
