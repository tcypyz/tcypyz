package com.example.smserver.dto;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/28
 */
@Data
@ToString
public class UserEditDTO {
    private Long id;
    private String name;
    private String phone;
    private Integer sex;
    private LocalDateTime birth;
    private Long roleId;
}
