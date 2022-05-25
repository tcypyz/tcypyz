package com.example.smserver.core.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result <T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

}
