package com.example.smserver.api.service.impl;

import com.example.smserver.api.service.MemberService;
import com.example.smserver.converter.TeacherTableConverter;
import com.example.smserver.core.base.BaseDTO;
import com.example.smserver.entity.Teacher;
import com.example.smserver.entity.User;
import com.example.smserver.service.TeacherService;
import com.example.smserver.service.UserService;
import com.example.smserver.utils.PageInfoUtils;
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

    @Override
    public PageInfo<TeacherTableVO> getPage(BaseDTO dto) {
        PageHelper.startPage(dto.getPage(), dto.getSize());
        List<Teacher> teacherList = teacherService.list();
        List<TeacherTableVO> resList = TeacherTableConverter.INSTANCE.toDataList(teacherList);

        resList.forEach(item -> {
            Teacher teacher = teacherService.getBaseMapper().getTchByNo(item.getUserId());
            User user = userService.getBaseMapper().getTeaVoByNo(teacher.getUserId());

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
