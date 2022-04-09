package com.example.smserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.smserver.entity.RoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/4
 */
@Mapper
@Repository
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {
}
