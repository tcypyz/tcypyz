package com.example.smserver.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/14
 */
@TableName("sms_test")
@Data
@ToString
public class Test implements Serializable {
    private Long id;
}
