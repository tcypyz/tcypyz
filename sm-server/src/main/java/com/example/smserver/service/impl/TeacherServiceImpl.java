package com.example.smserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.smserver.converter.TeacherTableConverter;
import com.example.smserver.core.base.BaseDTO;
import com.example.smserver.entity.*;
import com.example.smserver.mapper.TeacherMapper;
import com.example.smserver.mapper.UserMapper;
import com.example.smserver.service.*;
import com.example.smserver.utils.PageInfoUtils;
import com.example.smserver.vo.TeacherTableVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/7
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<TeacherTableVO> getPage(BaseDTO dto) {
        PageHelper.startPage(dto.getPage(), dto.getSize());
        List<Teacher> teacherList = list();
        List<TeacherTableVO> resList = TeacherTableConverter.INSTANCE.toDataList(teacherList);

        resList.forEach(item -> {
            System.out.println("UserId:"+item.getUserId());
            Teacher teacher = teacherMapper.getTchByNo(item.getUserId());
            System.out.println("teacher:---->"+teacher.getUserId());
            User user = userMapper.getTeaVoByNo(teacher.getUserId());
            System.out.println("user:--->"+user);

            item.setName(user.getName());
            item.setPhone(user.getPhone());
            item.setSex(user.getSex());
        });

        PageInfo<TeacherTableVO> result = new PageInfo<>();
        PageInfoUtils.transform(new PageInfo<>(teacherList), result);

        result.setList(resList);
        return result;
    }
}
