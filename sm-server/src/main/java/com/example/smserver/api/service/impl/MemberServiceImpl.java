package com.example.smserver.api.service.impl;

import com.example.smserver.api.service.MemberService;
import com.example.smserver.converter.StudentTableConverter;
import com.example.smserver.converter.TeacherTableConverter;
import com.example.smserver.core.base.BaseDTO;
import com.example.smserver.entity.Student;
import com.example.smserver.entity.Teacher;
import com.example.smserver.entity.User;
import com.example.smserver.service.StudentService;
import com.example.smserver.service.TeacherService;
import com.example.smserver.service.UserService;
import com.example.smserver.utils.PageInfoUtils;
import com.example.smserver.vo.StudentTableVO;
import com.example.smserver.vo.TeacherTableVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/28
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private UserService userService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @Override
    public PageInfo<TeacherTableVO> getPage(BaseDTO dto) {
        PageHelper.startPage(dto.getPage(), dto.getSize());
        List<Teacher> teacherList = teacherService.list();
        List<TeacherTableVO> resList = TeacherTableConverter.INSTANCE.toDataList(teacherList);
        resList.forEach(item -> {
            User user = userService.getById(item.getUserId());
            item.setName(user.getName());
            item.setPhone(user.getPhone());
            item.setSex(user.getSex());
        });
        PageInfo<TeacherTableVO> result = new PageInfo<>();
        PageInfoUtils.transform(new PageInfo<>(teacherList), result);
        result.setList(resList);
        return result;
    }

    @Override
    public List<StudentTableVO> getstuPage() {
        List<Student> studentList = studentService.list();
        List<StudentTableVO> resList = StudentTableConverter.INSTANCE.toDataList(studentList);
        resList.forEach(item -> {
            User user = userService.getById(item.getUserId());
            item.setName(user.getName());
            item.setPhone(user.getPhone());
            item.setSex(user.getSex());
        });
        return resList;
    }
}
