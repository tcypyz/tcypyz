package com.example.smserver.api.service.impl;

import com.example.smserver.api.service.ApiSelectClassService;
import com.example.smserver.converter.EnableScheduleConverter;
import com.example.smserver.converter.SelectClassVoConverter;
import com.example.smserver.core.context.DateContexts;
import com.example.smserver.entity.Course;
import com.example.smserver.entity.SelectClass;
import com.example.smserver.entity.User;
import com.example.smserver.service.CourseService;
import com.example.smserver.service.SelectClassService;
import com.example.smserver.service.UserService;
import com.example.smserver.vo.EnableScheduleVO;
import com.example.smserver.vo.SelectClassVO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wlt
 *
 */
@Service
public class ApiSelectClassServiceImpl implements ApiSelectClassService {

    @Autowired
    private SelectClassService selectClassService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @Override
    public void addCourseStudent(Long courseId, Long studentId) {
        selectClassService.getBaseMapper().addCourseStudent(courseId, studentId);
    }

    @Override
    public List<SelectClassVO> selectCourseStudent(Long studentId) {
        List<Long> courseIdList = selectClassService.simpleList(selectClassService.lambdaWrapper()
                .eq(SelectClass::getStudentId, studentId),SelectClass::getClassId);
        if(CollectionUtils.isEmpty(courseIdList)){
            return new ArrayList<>();
        }
        List<Course> courseList = courseService.lambdaQuery()
                .in(Course::getId, courseIdList)
                .list();
        List<Long> userIdList = courseList.stream()
                .map(Course::getOpenUserId)
                .collect(Collectors.toList());
        List<SelectClassVO> selectClassVOList = SelectClassVoConverter.INSTANCE.toDataList(courseList);
        Map<Long, String> userMap = userService.simpleMap(lambdaWrapper(User.class)
                        .in(CollectionUtils.isNotEmpty(userIdList), User::getId, userIdList),
                User::getId, User::getName);
        selectClassVOList.forEach(item -> item.setTeacherName(userMap.get(item.getOpenUserId())));
        return selectClassVOList;
    }

    @Override
    public List<EnableScheduleVO> getEnableSchedule(Long studentId) {
        List<Long> classIdList = selectClassService.simpleList(lambdaWrapper(SelectClass.class)
                        .eq(SelectClass::getStudentId, studentId),
                SelectClass::getClassId);
        List<Course> courseList = courseService.lambdaQuery()
                .notIn(CollectionUtils.isNotEmpty(classIdList), Course::getId, classIdList)
                .list();
        List<Long> teacherIds = courseList.stream()
                .map(Course::getOpenUserId)
                .collect(Collectors.toList());
        Map<Long, String> userMap = userService.simpleMap(lambdaWrapper(User.class)
                        .in(CollectionUtils.isNotEmpty(teacherIds), User::getId, teacherIds),
                User::getId, User::getName);
        List<EnableScheduleVO> resList = EnableScheduleConverter.INSTANCE.toDataList(courseList);
        resList.forEach(item -> {
            item.setTeacher(userMap.get(item.getOpenUserId()));
            item.setTime(item.getCreateTime().format(DateTimeFormatter.ofPattern(DateContexts.DATE_FORMAT))
                    + " - "
                    + item.getEndTime().format(DateTimeFormatter.ofPattern(DateContexts.DATE_FORMAT)));
        });
        return resList;
    }
}
