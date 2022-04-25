package com.example.smserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.smserver.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/28
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * id查找学生和教师
     *
     * @param id id
     * @return {@link User}
     */
    User getByNo(@Param("id") Long id);

    /**
     * user_id查找教师
     *
     * @param id id
     * @return {@link User}
     */
    User getTeaVoByNo(@Param("id") Long id);
}
