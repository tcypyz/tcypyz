package com.example.smserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.smserver.entity.Menu;
import com.example.smserver.entity.RoleMenu;
import com.example.smserver.entity.User;
import com.example.smserver.mapper.UserMapper;
import com.example.smserver.service.MenuService;
import com.example.smserver.service.RoleMenuService;
import com.example.smserver.service.RoleService;
import com.example.smserver.service.UserService;
import com.example.smserver.vo.MenuVO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
