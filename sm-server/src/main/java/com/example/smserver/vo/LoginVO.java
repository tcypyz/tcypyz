package com.example.smserver.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/28
 */
@Data
@Builder
@AllArgsConstructor
public class LoginVO implements Serializable {

    private Long id;
    private String token;
    private String username;
    private String no;
    private Integer sex;
    private String role;
    private String phone;

    public LoginVO() {}
}
