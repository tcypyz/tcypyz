package com.example.smserver.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


import java.io.Serializable;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/4
 */
@Data
@TableName("sms_menu")
public class Menu implements Serializable {
    @TableId
    private Long id;
    private String name;
    private String menuName;
    private String component;
    private String path;
    private String icon;
    private Long pid;
}
