package com.example.smserver.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/28
 */
@Data
@TableName("sms_role")
public class Role implements Serializable {
    @TableId
    private Long id;
    private String role;
    private String name;
}
