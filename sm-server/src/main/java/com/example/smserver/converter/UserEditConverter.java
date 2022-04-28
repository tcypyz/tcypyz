package com.example.smserver.converter;

import com.example.smserver.core.base.Converter;
import com.example.smserver.dto.UserEditDTO;
import com.example.smserver.entity.User;
import org.mapstruct.factory.Mappers;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/28
 */
@org.mapstruct.Mapper
public interface UserEditConverter extends Converter<User, UserEditDTO> {

    UserEditConverter INSTANCE = Mappers.getMapper(UserEditConverter.class);
}
