package com.example.smserver.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.smserver.api.service.ScoreInfoService;
import com.example.smserver.converter.ScoreTableVoConverter;
import com.example.smserver.dto.StudentScoreDTO;
import com.example.smserver.entity.Course;
import com.example.smserver.entity.Score;
import com.example.smserver.entity.User;
import com.example.smserver.service.CourseService;
import com.example.smserver.service.ScoreService;
import com.example.smserver.service.UserService;
import com.example.smserver.utils.BeanUtils;
import com.example.smserver.vo.ScoreTableVO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: zhh
 * @time: 2022/5/23
 */
@Service
public class ScoreInfoServiceImpl implements ScoreInfoService {

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @Override
    public List<ScoreTableVO> queryStudent(StudentScoreDTO dto, Long studentId) {
        List<Long> courseIds = null;
        if (BeanUtils.fieldNonNull(dto)){
            List<Long> userIdList = userService.simpleList(new LambdaQueryWrapper<User>()
                    .eq(User::getName, dto.getTeacher()), User::getId);
            courseIds = courseService.simpleList(new LambdaQueryWrapper<Course>()
                            .in(CollectionUtils.isNotEmpty(userIdList), Course::getOpenUserId, userIdList)
                            .eq(StringUtils.isNotEmpty(dto.getAcademic()), Course::getAcademic, dto.getAcademic())
                            .eq(StringUtils.isNotEmpty(dto.getClassName()), Course::getClassName, dto.getClassName()),
                    Course::getId);
        }
        List<Score> scores = scoreService.lambdaQuery()
                .in(CollectionUtils.isNotEmpty(courseIds), Score::getClassId, courseIds)
                .eq(Score::getStudentId, studentId)
                .list();
        String courseSql = "select class_id from sms_score where student_id = "+ studentId;
        String userSql = "select open_user_id from sms_course where id in ("+courseSql+")";
        Map<Long, String> userMap = userService.simpleMap(new LambdaQueryWrapper<User>().inSql(User::getId, userSql),
                User::getId, User::getName);
        Map<Long, Course> courseMap = courseService.simpleKeyMap(new LambdaQueryWrapper<Course>()
                        .inSql(Course::getId, courseSql), Course::getId);
        List<ScoreTableVO> scoreTableVoS = ScoreTableVoConverter.INSTANCE.toDataList(scores);
        scoreTableVoS.forEach(item -> {
            Course course = courseMap.get(item.getClassId());
            item.setTeacher(userMap.get(course.getOpenUserId()));
            item.setClassName(course.getClassName());
        });
        return scoreTableVoS;
    }
}
