package com.example.smserver.converter;

import com.example.smserver.core.base.Converter;
import com.example.smserver.entity.User;
import com.example.smserver.vo.UserTableVO;
import org.mapstruct.factory.Mappers;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/12
 */
@org.mapstruct.Mapper
public interface UserTableConverter extends Converter<User, UserTableVO> {

    UserTableConverter INSTANCE = Mappers.getMapper(UserTableConverter.class);
}
