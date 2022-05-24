package com.example.smserver.converter;

import com.example.smserver.core.base.Converter;
import com.example.smserver.entity.Course;
import com.example.smserver.vo.CourseVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author wlt
 */
@Mapper
public interface CourseVoConverter extends Converter<Course, CourseVO> {

    CourseVoConverter INSTANCE = Mappers.getMapper(CourseVoConverter.class);
}
