package com.example.smserver.dto;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/16
 */
@Data
@ToString
public class UserAddDTO {
    private String no;
    private String name;
    private String password;
    private Integer sex;
    private String phone;
    private Long role;
    private Date birth;
    /**
     * 学院
     */
    private String college;
    /**
     * 学生字段（专业）
     */
    private String profession;
    /**
     * 教师字段（职称）
     */
    private String occupation;
}
