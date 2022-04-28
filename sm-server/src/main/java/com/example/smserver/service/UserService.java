package com.example.smserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.smserver.core.base.BaseDTO;
import com.example.smserver.dto.IdDTO;
import com.example.smserver.dto.UserAddDTO;
import com.example.smserver.dto.UserEditDTO;
import com.example.smserver.entity.User;
import com.example.smserver.vo.MenuVO;
import com.example.smserver.vo.UserTableVO;
import com.github.pagehelper.PageInfo;

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
     * @param id id
     * @return {@link List}<{@link MenuVO}>
     */
    List<MenuVO> getMenuList(Long id);

    /**
     * 添加用户
     *
     * @param dto dto
     */
    void addUser(UserAddDTO dto);

    /**
     * 获取用户角色
     *
     * @param id id
     * @return {@link String}
     */
    String getRole(Long id);

    /**
     * 用户分页列表
     *
     * @param dto dto
     * @return {@link PageInfo}<{@link UserTableVO}>
     */
    PageInfo<UserTableVO> getPage(BaseDTO dto);

    /**
     * 删除用户
     *
     * @param dto dto
     */
    void deleteUser(IdDTO dto);

    /**
     * 编辑用户
     *
     * @param dto dto
     */
    void editUser(UserEditDTO dto);
}
