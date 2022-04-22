package com.example.smserver.handle.impl;

import com.example.smserver.dto.UserAddDTO;
import com.example.smserver.entity.Student;
import com.example.smserver.handle.AccountHandle;
import com.example.smserver.service.StudentService;
import com.example.smserver.type.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/21
 */
@Service
public class StudentAccountImpl implements AccountHandle<UserAddDTO> {

    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void process(UserAddDTO account, Long userId) {
        Student student = new Student();
        student.setId(Long.parseLong(account.getNo()));
        student.setUserId(userId);
        student.setCollege(account.getCollege());
        student.setProfession(account.getProfession());
        student.setInTime(LocalDateTime.now());
        studentService.getBaseMapper().insert(student);
    }

    @Override
    public RoleEnum getType() {
        return RoleEnum.STUDENT;
    }
}
