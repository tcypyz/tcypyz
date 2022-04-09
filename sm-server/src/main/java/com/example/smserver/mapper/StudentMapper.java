package com.example.smserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.smserver.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/7
 */
@Mapper
@Repository
public interface StudentMapper extends BaseMapper<Student> {
}
