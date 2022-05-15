package com.example.smserver.converter;

import com.example.smserver.core.base.Converter;
import com.example.smserver.entity.Course;
import com.example.smserver.vo.CourseListVO;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2022/5/14
 */
@org.mapstruct.Mapper
public interface CourseListVoConverter extends Converter<Course, CourseListVO> {

    CourseListVoConverter INSTANCE = Mappers.getMapper(CourseListVoConverter.class);

    /**
     * 数据列表
     *
     * @param courses 课程
     * @return {@link List}<{@link CourseListVO}>
     */
    @Override
    @Mappings({
            @Mapping(target = "className", source = "name")
    })
    List<CourseListVO> toDataList(List<Course> courses);
}
