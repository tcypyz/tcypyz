package com.example.smserver.service.impl;

import com.example.smserver.core.CustomException;
import com.example.smserver.core.context.LoginContexts;
import com.example.smserver.entity.User;
import com.example.smserver.service.SystemService;
import com.example.smserver.utils.EncryptUtils;
import com.example.smserver.utils.RedisUtils;
import com.example.smserver.utils.TokenUtils;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Objects;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/28
 */
@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public User userLogin(String id, String password) throws CustomException {
        User user = userService.lambdaQuery()
                .eq(StringUtils.isNotEmpty(id), User::getName, id).or()
                .eq(User::getNo, id).or()
                .eq(User::getPhone, id)
                .one();
        if (Objects.isNull(user)) {
            throw new CustomException(LoginContexts.USER_NOT_EXIST);
        }
        if (user.getPassword().equals(EncryptUtils.encrypt(password))) {
            return user;
        }
        throw new CustomException(LoginContexts.PASSWORD_IS_ERROR);
    }

    @Override
    public String createToken(HttpServletResponse response, String id) throws UnsupportedEncodingException {
        Long currentTimeMillis = System.currentTimeMillis();
        String token = TokenUtils.sign(id, currentTimeMillis);
        redisUtils.set(id, currentTimeMillis, TokenUtils.REFRESH_EXPIRE_TIME);
        response.setHeader("Authorization", token);
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        return token;
    }
}
