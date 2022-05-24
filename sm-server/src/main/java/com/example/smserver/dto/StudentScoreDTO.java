package com.example.smserver.dto;

import com.example.smserver.core.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: zhh
 * @time: 2022/5/23
 */

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class StudentScoreDTO extends BaseDTO {
    private String teacher;
    private String academic;
    private String className;

}
