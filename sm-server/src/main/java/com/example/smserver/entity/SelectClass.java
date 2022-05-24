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
@TableName("sms_select_class")
public class SelectClass implements Serializable {
    @TableId
    private Long id;
    private Long studentId;
    private Long classId;
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}
