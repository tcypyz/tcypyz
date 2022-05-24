package com.example.smserver.dto;

import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/28
 */
@Data
public class IdDTO {
    private Long id;
    private List<Long> idList;
}
