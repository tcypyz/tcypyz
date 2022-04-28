package com.example.smserver.api.service;

import com.example.smserver.core.base.BaseDTO;
import com.example.smserver.vo.TeacherTableVO;
import com.github.pagehelper.PageInfo;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/28
 */
public interface MemberService {
    /**
     * 用户分页列表
     *
     * @param dto dto
     * @return {@link PageInfo}<{@link TeacherTableVO}>
     */
    PageInfo<TeacherTableVO> getPage(BaseDTO dto);

}
