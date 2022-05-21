package com.example.smserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.smserver.dto.CourseDTO;
import com.example.smserver.entity.Course;
import com.example.smserver.vo.CourseVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/12
 */
@Mapper
public interface CourseMapper extends BaseMapper<Course> {


    /**
     * 查询课程-老师
     *
     * @param courseVO 课程vo
     * @return {@link List}<{@link CourseVO}>
     */
    List<CourseVO> selectCourseTeacher(@Param("CourseVO") CourseVO courseVO);

    /**
     * 添加课程-老师
     *
     * @param courseDTO 课程dto
     * @return int
     */
    int addCourseTeacher(@Param("CourseDTO") CourseDTO courseDTO);

    /**
     * 删除课程-老师
     *
     * @param courseId 课程id
     * @return int
     */
    int deleteCourseTeacher(@Param("courseId") Long courseId);

    /**
     * 更新课程-老师
     *
     * @param courseDTO 课程dto
     * @return int
     */
    int updateCourseTeacher(@Param("CourseDTO") CourseDTO courseDTO);
}
