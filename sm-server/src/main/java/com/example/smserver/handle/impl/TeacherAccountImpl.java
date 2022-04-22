package com.example.smserver.handle.impl;

import com.example.smserver.dto.UserAddDTO;
import com.example.smserver.entity.Teacher;
import com.example.smserver.handle.AccountHandle;
import com.example.smserver.service.TeacherService;
import com.example.smserver.type.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/22
 */
@Service
public class TeacherAccountImpl implements AccountHandle<UserAddDTO> {

    private TeacherService teacherService;

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Override
    public void process(UserAddDTO dto, Long userId) {
        Teacher teacher = new Teacher();
        teacher.setUserId(userId);
        teacher.setId(Long.parseLong(dto.getNo()));
        teacher.setCollege(dto.getCollege());
        teacher.setInTime(LocalDateTime.now());
        teacher.setOccupation(dto.getOccupation());
        teacherService.getBaseMapper().insert(teacher);
    }

    @Override
    public RoleEnum getType() {
        return RoleEnum.TEACHER;
    }
}
