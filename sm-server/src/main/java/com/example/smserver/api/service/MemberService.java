package com.example.smserver.api.service;

import com.example.smserver.core.base.entity.BaseDTO;
import com.example.smserver.vo.StudentTableVO;
import com.example.smserver.vo.TeacherTableVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

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
    List<StudentTableVO> getstuPage();

}
