package com.example.smserver.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description:
 * @author: zhh
 * @time: 2022/5/19
 */
@Data
public class UserInfoVO implements Serializable {
    private String college;
    private String profession;
    private String no;
}
