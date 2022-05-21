package com.example.smserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.smserver.entity.SelectClass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/12
 */
@Mapper
public interface SelectClassMapper extends BaseMapper<SelectClass> {

    /**
     * 添加课程-学生
     *
     * @param courseId  进程id
     * @param studentId 学生id
     * @return int
     */
    int addCourseStudent(@Param("courseId") Long courseId, @Param("studentId") Long studentId);

    /**
     * 删除课程-学生
     *
     * @param courseId  进程id
     * @param studentId 学生id
     * @return int
     */
    int deleteCourseStudent(@Param("courseId") Long courseId, @Param("studentId") Long studentId);

}
