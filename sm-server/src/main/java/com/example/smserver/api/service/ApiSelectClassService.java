package com.example.smserver.api.service;

import com.example.smserver.core.base.entity.BaseService;
import com.example.smserver.vo.EnableScheduleVO;
import com.example.smserver.vo.SelectClassVO;

import java.util.List;

/**
 * @author wlt
 */
public interface ApiSelectClassService extends BaseService {

    /**
     * 添加课程学生
     *
     * @param courseId  课程id
     * @param studentId 学生证
     */
    void addCourseStudent(Long courseId, Long studentId);


    /**
     * 学生选择列表
     *
     * @param studentId 学生id
     * @return {@link List}<{@link SelectClassVO}>
     */
    List<SelectClassVO> selectCourseStudent(Long studentId);

    /**
     * 学生可选课表
     *
     * @param studentId 学生id
     * @return {@link List}<{@link EnableScheduleVO}>
     */
    List<EnableScheduleVO> getEnableSchedule(Long studentId);
}
