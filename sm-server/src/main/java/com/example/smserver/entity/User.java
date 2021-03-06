package com.example.smserver.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/26
 */
@Data
@Builder
@AllArgsConstructor
@TableName("sms_user")
public class User implements Serializable {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String name;
    private String password;
    private String phone;
    private Integer sex;
    private Long roleId;
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    private LocalDateTime birth;

    public User() {
    }

}
