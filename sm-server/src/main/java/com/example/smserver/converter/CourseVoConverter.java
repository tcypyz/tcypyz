package com.example.smserver.converter;

import com.example.smserver.core.base.Converter;
import com.example.smserver.entity.Course;
import com.example.smserver.vo.SelectClassVO;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper
public interface CourseVoConverter extends Converter<Course, SelectClassVO> {

    CourseVoConverter INSTANCE = Mappers.getMapper(CourseVoConverter.class);
}
