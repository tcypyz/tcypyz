package com.example.smserver.converter;

import com.example.smserver.core.base.Converter;
import com.example.smserver.entity.Course;
import com.example.smserver.vo.SelectClassVO;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper
public interface SelectClassVoConverter extends Converter<Course, SelectClassVO> {

    //建立单例
    SelectClassVoConverter INSTANCE = Mappers.getMapper(SelectClassVoConverter.class);
}
