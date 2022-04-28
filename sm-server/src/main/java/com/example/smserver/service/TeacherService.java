package com.example.smserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.smserver.core.base.BaseDTO;
import com.example.smserver.entity.Teacher;
import com.example.smserver.vo.TeacherTableVO;
import com.github.pagehelper.PageInfo;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/7
 */

public interface TeacherService extends IService<Teacher> {

    /**
     * 用户分页列表
     *
     * @param dto dto
     * @return {@link PageInfo}<{@link TeacherTableVO}>
     */
    PageInfo<TeacherTableVO> getPage(BaseDTO dto);

}
