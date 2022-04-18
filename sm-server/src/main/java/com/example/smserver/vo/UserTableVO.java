package com.example.smserver.vo;

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
public class UserTableVO implements Serializable {
    private Long id;
    private String name;
    private String phone;
    private Integer sex;
    private LocalDateTime createTime;
    private String role;
    private Integer age;
    private LocalDateTime birth;
    private Long roleId;
}
