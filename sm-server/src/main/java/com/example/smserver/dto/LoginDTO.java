package com.example.smserver.dto;

import lombok.Data;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/28
 */
@Data
public class LoginDTO {
    private String id;
    private String password;
    private String code;
    private String key;
}
