package com.example.smserver.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/28
 */
@Data
@ToString
public class IdDTO {
    private Long id;
    private List<Long> idList;
}
