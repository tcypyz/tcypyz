package com.example.smserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.smserver.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/7
 */
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {

}
