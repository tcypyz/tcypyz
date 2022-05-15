package com.example.smserver.handle.impl;

import com.example.smserver.converter.CourseListVoConverter;
import com.example.smserver.core.context.DigitalContexts;
import com.example.smserver.entity.Course;
import com.example.smserver.entity.User;
import com.example.smserver.handle.DashboardHandle;
import com.example.smserver.service.CourseService;
import com.example.smserver.type.RoleEnum;
import com.example.smserver.vo.CourseListVO;
import com.example.smserver.vo.DashboardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: zhh
 * @time: 2022/5/14
 */

@Service
public class TeaDashboardImpl implements DashboardHandle {

    @Autowired
    private CourseService courseService;

    @Override
    public DashboardVO process(User user) {
        List<Course> courseList = courseService.lambdaQuery().eq(Course::getOpenUserId, user.getId()).list();
        List<CourseListVO> courseListVoS = CourseListVoConverter.INSTANCE.toDataList(courseList);
        courseListVoS.forEach(item -> item.setTeacher(user.getName()));
        return DashboardVO.builder()
                .select(courseList.size())
                .score(DigitalContexts.ZERO)
                .xAxis(courseList.stream().map(Course::getClassName).collect(Collectors.toList()))
                .series(courseList.stream().map(item -> item.getCountNum() - item.getUnselected()).collect(Collectors.toList()))
                .courseList(courseListVoS)
                .build();
    }

    @Override
    public RoleEnum getType() {
        return RoleEnum.TEACHER;
    }
}
