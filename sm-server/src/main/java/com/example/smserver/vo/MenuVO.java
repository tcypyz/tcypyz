package com.example.smserver.vo;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/4
 */
@EqualsAndHashCode()
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuVO implements Serializable {
    private Long id;
    private String name;
    private String menuName;
    private String component;
    private String path;
    private String icon;
    private List<MenuVO> children;
}
