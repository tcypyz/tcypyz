package com.example.smserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.smserver.converter.UserTableConverter;
import com.example.smserver.core.CustomException;
import com.example.smserver.core.base.BaseDTO;
import com.example.smserver.core.context.DigitalContexts;
import com.example.smserver.dto.UserAddDTO;
import com.example.smserver.entity.*;
import com.example.smserver.handle.client.AccountClient;
import com.example.smserver.mapper.UserMapper;
import com.example.smserver.service.*;
import com.example.smserver.type.RoleEnum;
import com.example.smserver.utils.DateUtils;
import com.example.smserver.utils.EncryptUtils;
import com.example.smserver.utils.PageInfoUtils;
import com.example.smserver.vo.MenuVO;
import com.example.smserver.vo.UserTableVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleMenuService roleMenuService;

    @Autowired
    private AccountClient<UserAddDTO> accountClient;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Override
    public List<MenuVO> getMenuList(Long id) {
        User user = getById(id);
        Long roleId = user.getRoleId();
        List<Long> menuIdList = roleMenuService.lambdaQuery()
                .eq(Objects.nonNull(roleId), RoleMenu::getRoleId, roleId)
                .list()
                .stream()
                .map(RoleMenu::getMenuId)
                .collect(Collectors.toList());
        List<Menu> menuList = menuService.lambdaQuery()
                .in(CollectionUtils.isNotEmpty(menuIdList), Menu::getId, menuIdList)
                .orderByAsc(Menu::getId)
                .list();
        List<MenuVO> result = new ArrayList<>();
        menuList.forEach( item -> {
            if (item.getPid().equals(0L)) {
                result.add(convert(item));
            } else {
                result.forEach( resultItem -> {
                    if (item.getPid().equals(resultItem.getId())){
                        List<MenuVO> children = resultItem.getChildren();
                        if (CollectionUtils.isEmpty(children)){
                            children = new ArrayList<>();
                        }
                        children.add(convert(item));
                        resultItem.setChildren(children);
                    }
                });
            }
        });
        return result;
    }

    @Override
    public void addUser(UserAddDTO dto) {
        dto.setPassword(EncryptUtils.encrypt(dto.getPassword()));
        User user = User.builder()
                .name(dto.getName())
                .password(dto.getPassword())
                .sex(dto.getSex())
                .phone(dto.getPhone())
                .roleId(dto.getRole())
                .createTime(LocalDateTime.now())
                .birth(DateUtils.toLocalDateTime(dto.getBirth()))
                .build();
        Integer insert = baseMapper.insert(user);
        if (!insert.equals(DigitalContexts.ONE)){
            throw new CustomException();
        }
        if (!user.getRoleId().equals(RoleEnum.ADMIN.id)){
            accountClient.doHandler(user.getRoleId().toString(), dto, user.getId());
        }
    }

    @Override
    public String getRole(Long id) {
        return roleService.lambdaQuery().eq(Role::getId, id).one().getName();
    }

    @Override
    public PageInfo<UserTableVO> getPage(BaseDTO dto) {
        PageHelper.startPage(dto.getPage(), dto.getSize());
        List<User> userList = list();
        List<UserTableVO> resList = UserTableConverter.INSTANCE.toDataList(userList);
        resList.forEach(item -> {
            item.setRole(getRole(item.getRoleId()));
            int now = LocalDateTime.now().getYear();
            int age = now - item.getBirth().getYear();
            item.setAge(age);
        });
        PageInfo<UserTableVO> result = new PageInfo<>();
        PageInfoUtils.transform(new PageInfo<>(userList), result);
        result.setList(resList);
        return result;
    }


    private MenuVO convert (Menu from) {
        return MenuVO.builder()
                .id(from.getId())
                .name(from.getName())
                .menuName(from.getMenuName())
                .component(from.getComponent())
                .icon(from.getIcon())
                .path(from.getPath()).build();
    }
}
