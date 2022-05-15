package com.example.smserver.handle.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.smserver.converter.CourseListVoConverter;
import com.example.smserver.core.CustomException;
import com.example.smserver.core.context.DigitalContexts;
import com.example.smserver.core.context.ErrorContexts;
import com.example.smserver.entity.Course;
import com.example.smserver.entity.Score;
import com.example.smserver.entity.SelectClass;
import com.example.smserver.entity.User;
import com.example.smserver.handle.DashboardHandle;
import com.example.smserver.service.CourseService;
import com.example.smserver.service.ScoreService;
import com.example.smserver.service.SelectClassService;
import com.example.smserver.service.UserService;
import com.example.smserver.type.RoleEnum;
import com.example.smserver.vo.CourseListVO;
import com.example.smserver.vo.DashboardVO;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: zhh
 * @time: 2022/5/14
 */
@Service
public class StuDashboardImpl implements DashboardHandle {

    @Autowired
    private SelectClassService selectClassService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @Autowired
    private ScoreService scoreService;

    @Override
    public DashboardVO process(User user) {
        List<SelectClass> selectClassList = selectClassService.lambdaQuery()
                .eq(SelectClass::getStudentId, user.getId())
                .list();
        if (CollectionUtils.isEmpty(selectClassList)){
            return new DashboardVO();
        }
        List<Long> classIdList = selectClassList.stream().map(SelectClass::getClassId).collect(Collectors.toList());
        List<Course> courseList = courseService.list(new LambdaQueryWrapper<Course>().in(Course::getId, classIdList));
        List<CourseListVO> courseListVoS = CourseListVoConverter.INSTANCE.toDataList(courseList);
        courseListVoS.forEach(item -> {
            User teacher = userService.getById(item.getOpenUserId());
            if (Objects.isNull(teacher)){
                throw new CustomException(ErrorContexts.DATABASE_ERROR);
            }
            item.setTeacher(teacher.getName());
        });
        List<Score> scoreList = scoreService.list(new LambdaQueryWrapper<Score>().in(Score::getClassId, classIdList));
        return DashboardVO.builder()
                .select(selectClassList.size())
                .score(scoreList.stream()
                        .mapToInt(item-> Objects.isNull(item.getResult()) ? DigitalContexts.ZERO : item.getResult())
                        .sum())
                .xAxis(courseList.stream().map(Course::getClassName).collect(Collectors.toList()))
                .series(courseList.stream().map(item -> item.getCountNum() - item.getUnselected()).collect(Collectors.toList()))
                .courseList(courseListVoS)
                .build();
    }

    @Override
    public RoleEnum getType() {
        return RoleEnum.STUDENT;
    }
}
