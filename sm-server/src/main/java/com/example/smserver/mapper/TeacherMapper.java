package com.example.smserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.smserver.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/7
 */
@Repository
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {
}
