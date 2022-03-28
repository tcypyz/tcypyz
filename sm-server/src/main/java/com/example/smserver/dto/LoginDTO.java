package com.example.smserver.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/28
 */
@Data
@ToString
public class LoginDTO {
    private String username;
    private String no;
    private String phone;
    private String password;
    private String code;
    private String key;
}