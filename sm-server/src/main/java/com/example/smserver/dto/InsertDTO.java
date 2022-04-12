package com.example.smserver.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/10
 */
@Data
@ToString
public class InsertDTO {
    private String no;
    private String name;
    private String password;
    private Integer sex;
    private String phone;
    private Integer role;
}
