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
@TableName("sms_course")
public class Course implements Serializable {
    @TableId
    private Long id;
    private String className;
    private Long openUserId;
    private Integer status;
    private String academic;
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    private LocalDateTime endTime;
    private Integer unselected;
    private Integer count;
}
