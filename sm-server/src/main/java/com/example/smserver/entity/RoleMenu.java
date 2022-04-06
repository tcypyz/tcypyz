package com.example.smserver.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/4
 */
@Data
@ToString
@TableName("sms_role_menu")
public class RoleMenu implements Serializable {
    @TableId
    private Long id;
    private Long roleId;
    private Long menuId;
}
