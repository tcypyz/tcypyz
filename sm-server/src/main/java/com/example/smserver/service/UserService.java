package com.example.smserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.smserver.entity.User;
import com.example.smserver.vo.MenuVO;

import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/28
 */
public interface UserService extends IService<User> {

    /**
     * 菜单列表
     *
     * @return {@link List}<{@link MenuVO}>
     */
    List<MenuVO> getMenuList(Long id);
}
