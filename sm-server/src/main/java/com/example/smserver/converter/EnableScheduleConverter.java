package com.example.smserver.converter;

import com.example.smserver.core.base.Converter;
import com.example.smserver.entity.Course;
import com.example.smserver.vo.EnableScheduleVO;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2022/5/25
 */
@org.mapstruct.Mapper
public interface EnableScheduleConverter extends Converter<Course, EnableScheduleVO> {

    EnableScheduleConverter INSTANCE = Mappers.getMapper(EnableScheduleConverter.class);

    /**
     * 数据
     *
     * @param course 课程
     * @return {@link EnableScheduleVO}
     */
    @Mapping(target = "name", source = "className")
    @Override
    EnableScheduleVO toData(Course course);

    /**
     * 重写
     *
     * @param courses 课程
     * @return {@link List}<{@link EnableScheduleVO}>
     */
    @Override
    @Mappings({
        @Mapping(target = "name", source = "className")
    })
    List<EnableScheduleVO> toDataList(List<Course> courses);
}
