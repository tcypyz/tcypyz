package com.example.smserver.converter;

import com.example.smserver.core.base.Converter;
import com.example.smserver.entity.Student;
import com.example.smserver.vo.StudentTableVO;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper
public interface StudentTableConverter extends Converter<Student, StudentTableVO> {
    StudentTableConverter INSTANCE = Mappers.getMapper(StudentTableConverter.class);
}
