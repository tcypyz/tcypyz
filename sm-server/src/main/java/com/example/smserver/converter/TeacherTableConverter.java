package com.example.smserver.converter;

import com.example.smserver.core.base.Converter;
import com.example.smserver.entity.Teacher;
import com.example.smserver.vo.TeacherTableVO;
import org.mapstruct.factory.Mappers;

/**
 *
 * @description:
 * @author Yin
 * @time: 2022/4/22
 */
@org.mapstruct.Mapper
public interface TeacherTableConverter extends Converter<Teacher, TeacherTableVO> {

    TeacherTableConverter INSTANCE = Mappers.getMapper(TeacherTableConverter.class);
}
